package com.techware.controller;

import com.techware.model.Address;
import com.techware.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @CrossOrigin(origins = "http://localhost:4400")
@RequestMapping("api/v1")
public class AddressController {
    @Autowired
    private final AddressRepository repository;

    AddressController(AddressRepository repository) {
        this.repository = repository;
    }

    @PostMapping(path="/address")
    public Address newAddress(@RequestBody Address newAddress) {
        return repository.save(newAddress);
    }

    @PutMapping(path="/address/{id}")
    public ResponseEntity<Address> updateAddress(@RequestBody Address newAddress, @PathVariable Integer id) {
        Address updatedAddress = repository.findById(id)
                .map(address -> {
                    address = newAddress
                    return repository.save(address);
                })
                .orElseGet(() -> {
                    newAddress.setId(id);
                    return repository.save(newAddress);
                });
        return ResponseEntity.ok(updatedAddress);
    }

    @DeleteMapping(path="/address/{id}")
    public ResponseEntity<Address> deleteAddress(@RequestBody Address address, @)

}
