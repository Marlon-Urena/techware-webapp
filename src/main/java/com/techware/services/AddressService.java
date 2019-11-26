package com.techware.services;

import com.techware.model.Address;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

public interface AddressService {
    public abstract EntityModel<Address> one(Integer id);
    public abstract EntityModel<Address> all();
    public abstract ResponseEntity<Address> deleteAddress(Integer id);
    public abstract ResponseEntity<Address> updateAddress(Address newAddress, Integer id);
    public abstract ResponseEntity<Address> newAddress(Address newAddress);
}
