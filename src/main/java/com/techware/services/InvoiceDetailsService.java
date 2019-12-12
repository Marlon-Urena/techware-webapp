package com.techware.services;

import com.techware.model.InvoiceDetails;
import com.techware.model.InvoiceDetailsId;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

public interface InvoiceDetailsService {
    public abstract EntityModel<InvoiceDetails> getInvoiceDetailsById(InvoiceDetailsId invoiceDetailsId);
    public abstract CollectionModel<EntityModel<InvoiceDetails>> getAllInvoiceDetails(Integer invoiceId);
    public abstract ResponseEntity<InvoiceDetails> addInvoiceDetails(InvoiceDetails newinvoiceDetails);
    public abstract ResponseEntity<InvoiceDetails> updateInvoiceDetailsById(InvoiceDetails newInvoiceDetails, InvoiceDetailsId invoiceDetailsId);
    public abstract ResponseEntity<InvoiceDetails> deleteInvoiceDetailsById(InvoiceDetailsId invoiceDetailsId);
}
