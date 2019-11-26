package com.techware.controller;

import com.techware.assembler.InvoiceResourceAssembler;
import com.techware.exceptions.InvoiceNotFoundException;
import com.techware.model.Invoice;
import com.techware.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @CrossOrigin(origins = "https://localhost:8443")
@RequestMapping("/api/v1/invoice")
public class InvoiceController {

    private final InvoiceRepository repository;
    private final InvoiceResourceAssembler assembler;

    public InvoiceController (InvoiceRepository repository, InvoiceResourceAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping(path="")
    public EntityModel<Invoice> one(@RequestParam(value = "id") Integer id) {
        Invoice invoice = repository.findById(id).orElseThrow(() -> new InvoiceNotFoundException(id));
        return assembler.toModel(invoice);
    }

    @GetMapping(path="")

    @PostMapping(path="/add")
    public Invoice addInvoice(@RequestBody Invoice newInvoice) {
            return repository.save(newInvoice);
    }

    @PutMapping(path="/update")
    public ResponseEntity<Invoice> replaceInvoice(@RequestBody Invoice newInvoice, @RequestParam(name="id") Integer id) {
        Invoice updatedInvoice = repository.findById(id)
                .map(invoice -> {
                    Invoice.InvoiceBuilder invoiceBuilder = newInvoice.toBuilder();
                    invoice = invoiceBuilder.invoiceId(id).build();
                    return repository.save(invoice);
                })
                .orElseGet(() -> {
                    newInvoice.setInvoiceId(id);
                    return repository.save(newInvoice);
                });
        return ResponseEntity.ok(updatedInvoice);
    }
}
