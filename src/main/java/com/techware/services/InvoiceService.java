package com.techware.services;

import com.techware.model.Invoice;
import com.techware.model.InvoiceCreationRequest;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

public interface InvoiceService {
    public abstract EntityModel<Invoice> getInvoiceById(Integer id);
    public abstract CollectionModel<EntityModel<Invoice>> getAllInvoicesByBuyerId(Integer buyerId);
    public abstract ResponseEntity<Invoice> createInvoice(InvoiceCreationRequest newInvoice);
    public abstract ResponseEntity<Invoice> updateInvoiceById(Invoice newInvoice, Integer id);
    public abstract ResponseEntity<Invoice> deleteInvoiceById(Integer id);
}
