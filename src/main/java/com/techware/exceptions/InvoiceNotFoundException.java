package com.techware.exceptions;

public class InvoiceNotFoundException extends RuntimeException {
    public InvoiceNotFoundException(Integer id) {
        super("Could not find invoice with id" + id);
    }
}
