package com.techware.services;

import com.techware.model.InvoiceDetails;
import com.techware.model.InvoiceDetailsId;
import org.springframework.hateoas.EntityModel;

public interface InvoiceDetailsService {
    public abstract EntityModel<InvoiceDetails> one(InvoiceDetailsId invoiceDetailsId);
}
