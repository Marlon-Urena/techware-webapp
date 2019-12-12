package com.techware.exceptions;

import com.techware.model.UserAccountAddressId;

public class UserAccountAddressNotFoundException extends RuntimeException{
    public UserAccountAddressNotFoundException(UserAccountAddressId userAccountAddressId) {
        super("Could not find AddressID= " + userAccountAddressId.getAddressId() + "associated with UserAccountID= " + userAccountAddressId.getUserAccountId());
    }
}
