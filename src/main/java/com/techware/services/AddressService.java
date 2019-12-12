package com.techware.services;

import com.techware.model.Address;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface AddressService {
    public abstract EntityModel<Address> getAddressById(Integer id);
//    public abstract CollectionModel<EntityModel<Address>> getAllAddressesByUserAccountId(Integer id);
    public abstract ResponseEntity<Address> deleteAddressById(Integer id);
    public abstract ResponseEntity<Address> updateAddressById(Address newAddress, Integer id);
    public abstract ResponseEntity<Address> addAddress(Address newAddress);
}
