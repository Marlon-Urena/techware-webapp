package com.techware.repository;

import com.techware.model.InvoiceDetails;
import com.techware.model.InvoiceDetailsId;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface InvoiceDetailsRepository extends CrudRepository<InvoiceDetails, InvoiceDetailsId> {
    public Optional<InvoiceDetails> findByProductId(InvoiceDetailsId productId);
    public Optional<InvoiceDetails> findByInvoiceId(InvoiceDetailsId invoiceId);
    public Optional<InvoiceDetails> findByProductIdAndInvoiceId(InvoiceDetailsId invoiceDetailsId);
}
