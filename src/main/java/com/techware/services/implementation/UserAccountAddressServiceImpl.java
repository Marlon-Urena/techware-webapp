package com.techware.services.implementation;

import com.techware.assembler.UserAccountAddressResourceAssembler;
import com.techware.exceptions.UserAccountAddressNotFoundException;
import com.techware.model.UserAccountAddress;
import com.techware.model.UserAccountAddressId;
import com.techware.repository.UserAccountAddressRepository;
import com.techware.services.UserAccountAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAccountAddressServiceImpl implements UserAccountAddressService {

    @Autowired
    private final UserAccountAddressRepository repository;
    @Autowired
    private final UserAccountAddressResourceAssembler assembler;

    public UserAccountAddressServiceImpl(UserAccountAddressRepository repository, UserAccountAddressResourceAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }
    @Override
    public CollectionModel<EntityModel<UserAccountAddress>> getAllUserAccountAddresses(Integer userAccountId) {
        List<EntityModel<UserAccountAddress>> userAccountAddress = repository.findAllByUserAccountAddressId_UserAccountId(userAccountId).stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return new CollectionModel<>(userAccountAddress);
    }

    @Override
    public ResponseEntity<UserAccountAddress> addUserAccountAddress(UserAccountAddress newUserAccountAddress) {
        EntityModel<UserAccountAddress> entity = assembler.toModel(repository.save(newUserAccountAddress));
        return ResponseEntity.created(URI.create("/invoiceDetails/" + entity.getContent().getUserAccountAddressId())).build();
    }

    @Override
    public ResponseEntity<UserAccountAddress> updateUserAccountAddress(UserAccountAddress newUserAccountAddress, UserAccountAddressId userAccountAddressId) {
        UserAccountAddress updatedUserAccountAddress = repository.findById(userAccountAddressId)
                .map(invoiceDetails -> {
                    UserAccountAddress.UserAccountAddressBuilder invoiceDetailsBuilder = newUserAccountAddress.toBuilder();
                    invoiceDetails = invoiceDetailsBuilder.userAccountAddressId(userAccountAddressId).build();
                    return repository.save(invoiceDetails);
                })
                .orElseGet(() -> {
                    newUserAccountAddress.setUserAccountAddressId(userAccountAddressId);
                    return repository.save(newUserAccountAddress);
                });
        return ResponseEntity.ok(updatedUserAccountAddress);
    }

    @Override
    public ResponseEntity<UserAccountAddress> deleteUserAccountAddress(UserAccountAddressId userAccountAddressId) {
        repository.deleteById(userAccountAddressId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public EntityModel<UserAccountAddress> getUserAccountAddressById(UserAccountAddressId userAccountAddressId) {
        UserAccountAddress userAccountAddress = repository.findById(userAccountAddressId).orElseThrow(() -> new UserAccountAddressNotFoundException(userAccountAddressId));
        return assembler.toModel(userAccountAddress);
    }
}
