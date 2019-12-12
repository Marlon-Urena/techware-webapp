package com.techware.services.implementation;

import com.techware.assembler.AddressResourceAssembler;
import com.techware.controller.AddressController;
import com.techware.exceptions.AddressNotFoundException;
import com.techware.model.Address;
import com.techware.repository.AddressRepository;
import com.techware.services.AddressService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private final AddressRepository repository;
    @Autowired
    private final AddressResourceAssembler assembler;

    public AddressServiceImpl(AddressRepository repository, AddressResourceAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @Override
    public EntityModel<Address> getAddressById(Integer addressId) {
        Address address = repository.findById(addressId).orElseThrow(() -> new AddressNotFoundException(addressId));
        return assembler.toModel(address);
    }

/*
    @Override
    public CollectionModel<EntityModel<Address>> getAllAddressesByUserAccountId (Integer id) {
        List<EntityModel<Address>> addresses = repository.getAllByUserAccountId(id).stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        Link link = linkTo(methodOn(AddressController.class).allAddressesFromUserAccount(id)).withSelfRel();

        return new CollectionModel<>(addresses,linkTo(methodOn(AddressController.class).allAddressesFromUserAccount(id)).withSelfRel());
    }
*/

    @Override
    public ResponseEntity<Address> deleteAddressById(Integer addressId) {
        repository.deleteById(addressId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Address> updateAddressById(Address newAddress, Integer addressId) {
        Address updatedAddress = repository.findById(addressId)
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

    @Override
    public ResponseEntity<Address> addAddress(Address newAddress) {
        EntityModel<Address> entity = assembler.toModel(repository.save(newAddress));
        return ResponseEntity.created(URI.create("/address/" + entity.getContent().getAddressId())).build();
    }
}
