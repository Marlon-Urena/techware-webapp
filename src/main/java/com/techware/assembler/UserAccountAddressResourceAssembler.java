package com.techware.assembler;

import com.techware.controller.UserAccountAddressController;
import com.techware.model.UserAccountAddress;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserAccountAddressResourceAssembler implements RepresentationModelAssembler<UserAccountAddress, EntityModel<UserAccountAddress>> {
    @Override
    public EntityModel<UserAccountAddress> toModel(UserAccountAddress userAccountAddress) {
        Link link = linkTo(methodOn(UserAccountAddressController.class).one(userAccountAddress.getUserAccountAddressId().getUserAccountId(), userAccountAddress.getUserAccountAddressId().getAddressId())).withSelfRel();
        return new EntityModel<UserAccountAddress>(userAccountAddress, link);
    }
}
