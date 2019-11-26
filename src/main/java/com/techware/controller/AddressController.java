package com.techware.controller;

import com.techware.assembler.AddressResourceAssembler;
import com.techware.exceptions.AddressNotFoundException;
import com.techware.model.Address;
import com.techware.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @CrossOrigin(origins = "https://localhost:8443")
@RequestMapping("/api/v1/address")
public class AddressController {

    @Autowired
    private final AddressRepository repository;

    @Autowired
    private final AddressResourceAssembler assembler;



    public AddressController(AddressRepository repository, AddressResourceAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping
    public EntityModel<Address> one(@RequestParam(value = "id") Integer id) {
        Address address = repository.findById(id).orElseThrow(() -> new AddressNotFoundException(id));
        return assembler.toModel(address);
    }

    @PostMapping
    public Address newAddress(@RequestBody Address newAddress) {
        return repository.save(newAddress);
    }

    @PutMapping
    public ResponseEntity<Address> updateAddress(@RequestBody Address newAddress, @RequestParam(name="id") Integer id) {
        Address updatedAddress = repository.findById(id)
                .map(address -> {
                    Address.AddressBuilder addressBuilder = newAddress.toBuilder();
                    address = addressBuilder.build();
                    return repository.save(address);
                })
                .orElseGet(() -> {
                    newAddress.getAddressId();
                    return repository.save(newAddress);
                });
        return ResponseEntity.ok(updatedAddress);
    }

    @DeleteMapping
    public ResponseEntity<Address> deleteAddress(@PathVariable Integer id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
