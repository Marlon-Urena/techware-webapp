package com.techware.services;

import com.techware.model.UserAccountAddress;
import com.techware.model.UserAccountAddressId;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

public interface UserAccountAddressService {
    public abstract CollectionModel<EntityModel<UserAccountAddress>> getAllUserAccountAddresses(Integer userAccountId);
    public abstract ResponseEntity<UserAccountAddress> addUserAccountAddress(UserAccountAddress newUserAccountAddress);
    public abstract ResponseEntity<UserAccountAddress> updateUserAccountAddress(UserAccountAddress newUserAccountAddress, UserAccountAddressId userAccountAddressId);
    public abstract ResponseEntity<UserAccountAddress> deleteUserAccountAddress(UserAccountAddressId userAccountAddressId);
    public abstract EntityModel<UserAccountAddress> getUserAccountAddressById(UserAccountAddressId userAccountAddressId);
}
