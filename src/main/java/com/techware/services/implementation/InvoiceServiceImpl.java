package com.techware.services.implementation;
import com.techware.model.*;
import com.techware.repository.*;
import org.springframework.hateoas.Link;

import com.techware.assembler.InvoiceResourceAssembler;
import com.techware.controller.InvoiceController;
import com.techware.exceptions.InvoiceNotFoundException;
import com.techware.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    private final InvoiceRepository repository;

    @Autowired
    private final InvoiceDetailsRepository detailsRepository;

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final InvoiceResourceAssembler assembler;
//
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.techware.invoice_catalog");
//    EntityManager entityManager = emf.createEntityManager();
    @PersistenceContext
    EntityManager entityManager;

    public InvoiceServiceImpl(InvoiceRepository repository, InvoiceDetailsRepository detailsRepository, ProductRepository productRepository, InvoiceResourceAssembler assembler) {
        this.repository = repository;
        this.productRepository = productRepository;
        this.assembler = assembler;
        this.detailsRepository = detailsRepository;
    }

    @Override
    public EntityModel<Invoice> getInvoiceById(Integer invoiceId) {
        Invoice invoice = repository.findById(invoiceId).orElseThrow(() -> new InvoiceNotFoundException(invoiceId));
        return assembler.toModel(invoice);
    }

    @Override
    public CollectionModel<EntityModel<Invoice>> getAllInvoicesByBuyerId(Integer buyerId) {
        List<EntityModel<Invoice>> invoices = repository.findAllByBuyerId_UserAccountId(buyerId).stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        Link invoiceLink = linkTo(methodOn(InvoiceController.class).allInvoicesFromBuyerId(buyerId)).withRel("invoices");
        return new CollectionModel<>(invoices, invoiceLink);
    }

    @Override
    public ResponseEntity<Invoice> createInvoice(InvoiceCreationRequest newInvoice) {
//        newInvoice.getInvoice().setBuyerId(newInvoice.getInvoice().getEntityManager().getReference(UserAccount.class, newInvoice.getInvoice().getBuyerId().getUserAccountId()));
//        newInvoice.getInvoice().setSellerId(newInvoice.getInvoice().getEntityManager().getReference(UserAccount.class, newInvoice.getInvoice().getSellerId().getUserAccountId()));
//        newInvoice.getInvoice().setDeliveryAddressId(newInvoice.getInvoice().getEntityManager().getReference(Address.class, newInvoice.get)getDeliveryAddressId());
//        newInvoice = processTransaction(newInvoice);
//        //newInvoice.getInvoice().getSellerId().setUserAccountId(4);
//        System.out.println(newInvoice.toString());
//
//        EntityModel<Invoice> entity = assembler.toModel(repository.save(newInvoice.getInvoice()));
//        newInvoice.getInvoiceDetails().get(0).getInvoiceDetailsId().setInvoiceId(entity.getContent().getInvoiceId());
//        detailsRepository.saveAll(newInvoice.getInvoiceDetails());
//        return ResponseEntity.created(URI.create("/invoice/" + entity.getContent().getInvoiceId())).build();
        Invoice invoice = processTransaction(newInvoice);
        EntityModel<Invoice> entity = assembler.toModel(repository.save(invoice));
        detailsRepository.save(new InvoiceDetails(new InvoiceDetailsId(newInvoice.getProductId(),entity.getContent().getInvoiceId())));
        return ResponseEntity.created(URI.create("/invoice/" + entity.getContent().getInvoiceId())).build();
    }

    @Override
    public ResponseEntity<Invoice> updateInvoiceById(Invoice newInvoice, Integer invoiceId) {
        Invoice updatedInvoice = repository.findById(invoiceId)
                .map(invoice -> {
                    Invoice.InvoiceBuilder invoiceBuilder = newInvoice.toBuilder();
                    invoice = invoiceBuilder.invoiceId(invoiceId).build();
                    return repository.save(invoice);
                })
                .orElseGet(() -> {
                    newInvoice.setInvoiceId(invoiceId);
                    return repository.save(newInvoice);
                });
        return ResponseEntity.ok(updatedInvoice);
    }

    @Override
    public ResponseEntity<Invoice> deleteInvoiceById(Integer invoiceId) {
        return null;
    }

    private Invoice processTransaction(InvoiceCreationRequest invoiceCreationRequest) {
        Invoice invoice = new Invoice();
        invoice.setBuyerId(entityManager.getReference(UserAccount.class, 3));
        invoice.setSellerId(entityManager.getReference(UserAccount.class, 1));
        invoice.setDeliveryAddressId(entityManager.getReference(Address.class, 2));
        invoice.setTotalPrice(productRepository.findByProductId(invoiceCreationRequest.getProductId()).getRentalPrice());
        invoice.setTransactionDate(LocalDate.now());
        invoice.setDeliveryDate(LocalDate.now().plusDays(3));
        invoice.setExpectedReturnDate(LocalDate.now().plusDays(10));
        return invoice;
    }
}
