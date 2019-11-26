package com.techware.exceptions;

public class AddressNotFoundException extends RuntimeException {

    public AddressNotFoundException(Integer id) {
        super("Address could not be found with id = " + id);
    }
}
