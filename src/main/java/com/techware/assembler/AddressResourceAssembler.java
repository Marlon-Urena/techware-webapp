package com.techware.assembler;

import com.techware.controller.AddressController;
import com.techware.model.Address;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class AddressResourceAssembler implements RepresentationModelAssembler<Address,EntityModel<Address>> {
    @Override
    public EntityModel<Address> toModel(Address address) {
        Link link = linkTo(methodOn(AddressController.class).one(address.getAddressId())).withSelfRel();
        return new EntityModel<Address>(address, link);
//                linkTo(methodOn(UserAccountController.class).one(userAccount.getId())).withSelfRel());
        //linkTo(methodOn(UserAccountController.class).deleteUserAccount(userAccount.getId())).withRel("user_Account"));

    }
}
