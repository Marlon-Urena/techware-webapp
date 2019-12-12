package com.techware.assembler;

import com.techware.controller.*;
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
        Link addressesLink = linkTo(methodOn(UserAccountAddressController.class).allAddressesByUserAccountId(userAccount.getUserAccountId())).withRel("addresses");
        Link invoicesLink = linkTo(methodOn(InvoiceController.class).allInvoicesFromBuyerId(userAccount.getUserAccountId())).withRel("invoices");
        Link productsLink = linkTo(methodOn(ProductController.class).allProductsFromUserAccount(userAccount.getUserAccountId())).withRel("products");
        return new EntityModel<UserAccount>(userAccount, link, addressesLink, invoicesLink, productsLink);
//                linkTo(methodOn(UserAccountController.class).one(userAccount.getId())).withSelfRel());
               //linkTo(methodOn(UserAccountController.class).deleteUserAccount(userAccount.getId())).withRel("user_Account"));
    }


}
