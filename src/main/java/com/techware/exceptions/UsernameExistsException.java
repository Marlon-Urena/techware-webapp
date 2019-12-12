package com.techware.exceptions;

public class UsernameExistsException extends RuntimeException {
    public UsernameExistsException(String username) {
        super("Username " + username + " has been taken. Try another.");
    }
}
