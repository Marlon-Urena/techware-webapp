package com.techware.exceptions;

import com.techware.model.InvoiceDetailsId;

public class InvoiceDetailsNotFoundException extends RuntimeException {
    public InvoiceDetailsNotFoundException (InvoiceDetailsId invoiceDetailsId) {
        super("Could not find Invoice Details with productid "+ invoiceDetailsId.getProductId() + " and invoiceid " + invoiceDetailsId.getInvoiceId() );
    }
}
