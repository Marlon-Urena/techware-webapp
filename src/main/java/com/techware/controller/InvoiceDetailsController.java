package com.techware.controller;

import com.techware.assembler.InvoiceDetailsResourceAssembler;
import com.techware.exceptions.InvoiceDetailsNotFoundException;
import com.techware.model.InvoiceDetails;
import com.techware.model.InvoiceDetailsId;
import com.techware.repository.InvoiceDetailsRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller @CrossOrigin("https://localhost:8443")
@RequestMapping(path = "/api/v1/invoicedetails")
public class InvoiceDetailsController {
    private final InvoiceDetailsRepository repository;
    private final InvoiceDetailsResourceAssembler assembler;

    public InvoiceDetailsController(InvoiceDetailsRepository repository, InvoiceDetailsResourceAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping(path = "")
    public EntityModel<InvoiceDetails> one(@RequestParam(name = "productId") Integer productId, @RequestParam(name = "invoiceId") Integer invoiceId) {

        InvoiceDetails invoiceDetails = repository.findByProductIdAndInvoiceId(new InvoiceDetailsId(productId,invoiceId)).orElseThrow(() -> new InvoiceDetailsNotFoundException(new InvoiceDetailsId(productId,invoiceId)));
        return assembler.toModel(invoiceDetails);
    }

    @PostMapping(path="/add")
    public InvoiceDetails addInvoice(@RequestBody InvoiceDetails newInvoiceDetails) {
        return repository.save(newInvoiceDetails);
    }

    @PutMapping(path="/update")
    public ResponseEntity<InvoiceDetails> replaceInvoiceDetails(@RequestBody InvoiceDetails newInvoiceDetails, @RequestParam(name="productId") Integer productId, @RequestParam(name = "invoiceId") Integer invoiceId) {
        InvoiceDetailsId invoiceDetailsId = new InvoiceDetailsId(productId, invoiceId);
        InvoiceDetails updatedInvoiceDetails = repository.findByProductIdAndInvoiceId(invoiceDetailsId)
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
}
