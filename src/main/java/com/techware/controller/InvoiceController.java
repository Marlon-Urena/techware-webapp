package com.techware.controller;

import com.techware.model.Invoice;
import com.techware.model.InvoiceCreationRequest;
import com.techware.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @CrossOrigin(origins = "https://localhost:8443")
@RequestMapping("/api/v1")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping(path = "/invoice")
    public EntityModel<Invoice> one(@RequestParam(value = "invoiceId") Integer invoiceId) {
        //return repository.findById(id);
        return invoiceService.getInvoiceById(invoiceId);
    }
    @GetMapping(path="/myaccount/invoices")
    public CollectionModel<EntityModel<Invoice>> allInvoicesFromBuyerId(@RequestParam(value = "useraccountId")Integer userAccountId){
        return invoiceService.getAllInvoicesByBuyerId(userAccountId);
    }

    @PostMapping(path="/checkout")
    public ResponseEntity<Invoice> addInvoice(@RequestBody InvoiceCreationRequest newInvoice) {
        return invoiceService.createInvoice(newInvoice);
    }

    @PutMapping(path="/invoice/update")
    public ResponseEntity<Invoice> replaceInvoice(@RequestBody Invoice newInvoice, @RequestParam(name="invoiceId") Integer invoiceId) {
        return invoiceService.updateInvoiceById(newInvoice, invoiceId);
    }
}
