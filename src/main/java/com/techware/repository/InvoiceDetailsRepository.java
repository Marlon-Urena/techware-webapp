package com.techware.repository;

import com.techware.model.Invoice;
import com.techware.model.InvoiceDetails;
import com.techware.model.InvoiceDetailsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface InvoiceDetailsRepository extends CrudRepository<InvoiceDetails, InvoiceDetailsId> {
    public List<InvoiceDetails> findAllByInvoiceDetailsId_InvoiceId(Integer invoiceId);
}
