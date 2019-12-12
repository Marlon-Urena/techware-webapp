package com.techware.exceptions;

public class UserAccountNotFoundException extends RuntimeException {

   public UserAccountNotFoundException(String username) {
        super("could not find " + username);
    }
    public UserAccountNotFoundException(Integer id) {
        super("could not find useraccount with id " + id );

    }
}
