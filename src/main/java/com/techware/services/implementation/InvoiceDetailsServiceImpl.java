package com.techware.services.implementation;

import com.techware.assembler.InvoiceDetailsResourceAssembler;
import com.techware.exceptions.InvoiceDetailsNotFoundException;
import com.techware.model.InvoiceDetails;
import com.techware.model.InvoiceDetailsId;
import com.techware.repository.InvoiceDetailsRepository;
import com.techware.services.InvoiceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceDetailsServiceImpl implements InvoiceDetailsService {
    @Autowired
    private final InvoiceDetailsRepository repository;
    @Autowired
    private final InvoiceDetailsResourceAssembler assembler;

    public InvoiceDetailsServiceImpl(InvoiceDetailsRepository repository, InvoiceDetailsResourceAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @Override
    public EntityModel<InvoiceDetails> getInvoiceDetailsById(InvoiceDetailsId invoiceDetailsId) {
        System.out.println(invoiceDetailsId.toString());
        InvoiceDetails invoiceDetails = repository.findById(invoiceDetailsId).orElseThrow(() -> new InvoiceDetailsNotFoundException(invoiceDetailsId));
        return assembler.toModel(invoiceDetails);
    }

    @Override
    public CollectionModel<EntityModel<InvoiceDetails>> getAllInvoiceDetails(Integer invoiceId) {
        List<EntityModel<InvoiceDetails>> invoiceDetails = repository.findAllByInvoiceDetailsId_InvoiceId(invoiceId).stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return new CollectionModel<>(invoiceDetails);
    }

    @Override
    public ResponseEntity<InvoiceDetails> addInvoiceDetails(InvoiceDetails newInvoiceDetails) {
        EntityModel<InvoiceDetails> entity = assembler.toModel(repository.save(newInvoiceDetails));
        return ResponseEntity.created(URI.create("/invoiceDetails/" + entity.getContent().getInvoiceDetailsId())).build();
    }

    @Override
    public ResponseEntity<InvoiceDetails> updateInvoiceDetailsById(InvoiceDetails newInvoiceDetails, InvoiceDetailsId invoiceDetailsId) {
        InvoiceDetails updatedInvoiceDetails = repository.findById(invoiceDetailsId)
                .map(invoiceDetails -> {
                    InvoiceDetails.InvoiceDetailsBuilder invoiceDetailsBuilder = newInvoiceDetails.toBuilder();
                    invoiceDetails = invoiceDetailsBuilder.invoiceDetailsId(invoiceDetailsId).build();
                    return repository.save(invoiceDetails);
                })
                .orElseGet(() -> {
                    newInvoiceDetails.setInvoiceDetailsId(invoiceDetailsId);
                    return repository.save(newInvoiceDetails);
                });
        return ResponseEntity.ok(updatedInvoiceDetails);
    }

    @Override
    public ResponseEntity<InvoiceDetails> deleteInvoiceDetailsById(InvoiceDetailsId invoiceDetailsId) {
        return null;
    }
}
