package com.techware.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Integer id) {
        super("Could not find Product with id " + id);
    }
}
