package com.techware.exceptions;

public class UserAccountNotFoundException extends RuntimeException {

   public UserAccountNotFoundException(Integer id) {
        super("could not find useraccount" + id);
    }
}
