package com.techware.controller;

import com.techware.model.Address;
import com.techware.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @CrossOrigin(origins = "https://localhost:8443")
@RequestMapping("/api/v1")
public class AddressController {

    @Autowired
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping(path = "/address")
    public EntityModel<Address> one(@RequestParam(value = "addressId") Integer addressId) {
        return addressService.getAddressById(addressId);
    }

/*
    @GetMapping(path= "/myaccount/addresses")
    public CollectionModel<EntityModel<Address>> allAddressesFromUserAccount(@RequestParam(value = "userAccountId")Integer userAccountId) {
        return addressService.getAllAddressesByUserAccountId(userAccountId);
    }
*/

    @PostMapping(path = "/myaccount/address")
    public ResponseEntity<Address> newAddress(@RequestBody Address newAddress) {
        return addressService.addAddress(newAddress);
    }

    @PutMapping(path = "/myaccount/address")
    public ResponseEntity<Address> updateAddress(@RequestBody Address newAddress, @RequestParam(name="addressId") Integer addressId) {
        return addressService.updateAddressById(newAddress, addressId);
    }

    @DeleteMapping(path = "/myaccount/address")
    public ResponseEntity<Address> deleteAddress(@RequestParam(name = "addressId") Integer addressId) {
        return addressService.deleteAddressById(addressId);
    }

}
