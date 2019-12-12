package com.techware.controller;

import com.techware.model.UserAccountAddress;
import com.techware.model.UserAccountAddressId;
import com.techware.services.UserAccountAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("https://localhost:8443")
@RequestMapping(path = "/api/v1")
public class UserAccountAddressController {
    @Autowired
    UserAccountAddressService userAccountAddressService;

    @GetMapping(path = "/useraccountaddress")
    public EntityModel<UserAccountAddress> one(@RequestParam(name = "useraccountId") Integer userAccountId, @RequestParam(name = "invoiceId") Integer invoiceId) {
        return userAccountAddressService.getUserAccountAddressById(new UserAccountAddressId(userAccountId,invoiceId));
    }

    @GetMapping(path = "/myaccount/addresses")
    public CollectionModel<EntityModel<UserAccountAddress>> allAddressesByUserAccountId(@RequestParam(name = "useraccountId") Integer userAccountId) {
        return userAccountAddressService.getAllUserAccountAddresses(userAccountId);
    }
}
