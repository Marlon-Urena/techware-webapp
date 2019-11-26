package com.techware.assembler;

import com.techware.controller.UserAccountController;
import com.techware.model.UserAccount;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;

@Component
public class UserAccountResourceAssembler implements RepresentationModelAssembler<UserAccount, EntityModel<UserAccount>> {

    @Override
    public EntityModel<UserAccount> toModel(UserAccount userAccount) {
        Link link = linkTo(methodOn(UserAccountController.class).one(userAccount.getUserAccountId())).withSelfRel();
        return new EntityModel<UserAccount>(userAccount, link);
//                linkTo(methodOn(UserAccountController.class).one(userAccount.getId())).withSelfRel());
               //linkTo(methodOn(UserAccountController.class).deleteUserAccount(userAccount.getId())).withRel("user_Account"));

    }
}
