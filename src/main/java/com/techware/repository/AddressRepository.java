package com.techware.repository;

import com.techware.model.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AddressRepository extends CrudRepository<Address, Integer> {
    //public Optional<Address> getAllByUserAccountId(Integer id);
    public Address findByAddressId(Integer addressId);
}
