package com.techware.exceptions;

public class InvalidLoginCredentialsException extends RuntimeException{
    public InvalidLoginCredentialsException() {
        super("Invalid login credentials");
    }
}
