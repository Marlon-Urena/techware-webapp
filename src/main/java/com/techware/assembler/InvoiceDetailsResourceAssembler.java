package com.techware.assembler;

import com.techware.controller.InvoiceController;
import com.techware.controller.InvoiceDetailsController;
import com.techware.controller.ProductController;
import com.techware.model.InvoiceDetails;
import com.techware.model.Product;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class InvoiceDetailsResourceAssembler implements RepresentationModelAssembler<InvoiceDetails,EntityModel<InvoiceDetails>> {
    @Override
    public EntityModel<InvoiceDetails> toModel(InvoiceDetails invoiceDetails) {
        Link link = linkTo(methodOn(InvoiceDetailsController.class).one(invoiceDetails.getInvoiceDetailsId().getProductId(),invoiceDetails.getInvoiceDetailsId().getInvoiceId())).withSelfRel();
        Link productLink = linkTo(methodOn(ProductController.class).one(invoiceDetails.getInvoiceDetailsId().getProductId())).withRel("product");
        Link invoiceLink = linkTo(methodOn(InvoiceController.class).one(invoiceDetails.getInvoiceDetailsId().getInvoiceId())).withRel("invoice");
        return new EntityModel<InvoiceDetails>(invoiceDetails, link,productLink,invoiceLink);
    }
}
