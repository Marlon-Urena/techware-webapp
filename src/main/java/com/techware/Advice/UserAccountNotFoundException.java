package com.techware.Advice;

import com.techware.exceptions.UserAccountAddressNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserAccountNotFoundException {
    @ResponseBody
    @ExceptionHandler(UserAccountAddressNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userAccountNotFoundInDatabase(UserAccountAddressNotFoundException ex) {
        return ex.getMessage();
    }
}
