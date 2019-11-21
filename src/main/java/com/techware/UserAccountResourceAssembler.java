package com.techware;

import com.techware.controller.UserAccountController;
import com.techware.model.UserAccount;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;

@Component
public class UserAccountResourceAssembler implements RepresentationModelAssembler<UserAccount, EntityModel<UserAccount>> {

    @Override
    public EntityModel<UserAccount> toModel(UserAccount userAccount) {

        return new EntityModel<UserAccount>(UserAccount userAccount,
                linkTo(methodOn(UserAccountController.class).one(userAccount.getId())).withSelfRel(),
                //linkTo(methodOn(UserAccountController.class).all()).withRel("user_accounts"));

    }
}
