package com.techware.assembler;

import com.techware.controller.InvoiceDetailsController;
import com.techware.model.InvoiceDetails;
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
        return new EntityModel<InvoiceDetails>(invoiceDetails, link);

    }
}
