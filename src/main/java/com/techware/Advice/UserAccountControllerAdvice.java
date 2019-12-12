package com.techware.Advice;

import com.techware.exceptions.EmailExistsException;
import com.techware.exceptions.InvalidLoginCredentialsException;
import com.techware.exceptions.UserAccountAddressNotFoundException;
import com.techware.exceptions.UsernameExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserAccountControllerAdvice {
    @ResponseBody
    @ExceptionHandler(EmailExistsException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    String emailExistInDatabaseHandler(EmailExistsException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(UsernameExistsException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    String emailExistInDatabaseHandler(UsernameExistsException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(UserAccountAddressNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userAccountNotFoundInDatabase(UserAccountAddressNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(InvalidLoginCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    String InvalidUsernameAndPasswordCombination(InvalidLoginCredentialsException ex) {
        return ex.getMessage();
    }
}
