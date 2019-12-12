package com.techware.controller;

import com.techware.model.InvoiceDetails;
import com.techware.model.InvoiceDetailsId;
import com.techware.repository.InvoiceDetailsRepository;
import com.techware.services.InvoiceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController @CrossOrigin("https://localhost:8443")
@RequestMapping(path = "/api/v1")
public class InvoiceDetailsController {
    @Autowired
    InvoiceDetailsService invoiceDetailsService;

    @GetMapping(path = "/invoicedetails")
    public EntityModel<InvoiceDetails> one(@RequestParam(name = "productId") Integer productId, @RequestParam(name = "invoiceId") Integer invoiceId) {
        System.out.println(productId + " " + invoiceId);
        return invoiceDetailsService.getInvoiceDetailsById(new InvoiceDetailsId(productId,invoiceId));
    }

    @GetMapping(path = "/myaccount/invoicedetails")
    public CollectionModel<EntityModel<InvoiceDetails>> allInvoiceDetailsByInvoiceId(@RequestParam(name = "invoiceId") Integer invoiceId) {
        return invoiceDetailsService.getAllInvoiceDetails(invoiceId);
    }

    @PostMapping(path="/add")
    public ResponseEntity<InvoiceDetails> addInvoice(@RequestBody InvoiceDetails newInvoiceDetails) {
        return invoiceDetailsService.addInvoiceDetails(newInvoiceDetails);
    }

    @PutMapping(path="/update")
    public ResponseEntity<InvoiceDetails> replaceInvoiceDetails(@RequestBody InvoiceDetails newInvoiceDetails, @RequestParam(name="productId") Integer productId, @RequestParam(name = "invoiceId") Integer invoiceId) {
        return invoiceDetailsService.updateInvoiceDetailsById(newInvoiceDetails,new InvoiceDetailsId(productId,invoiceId));
    }
}
