package com.techware.assembler;

import com.techware.controller.InvoiceController;
import com.techware.controller.InvoiceDetailsController;
import com.techware.model.Invoice;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class InvoiceResourceAssembler implements RepresentationModelAssembler<Invoice, EntityModel<Invoice>> {
    @Override
    public EntityModel<Invoice> toModel(Invoice invoice) {
        Link link = linkTo(methodOn(InvoiceController.class).one(invoice.getInvoiceId())).withSelfRel();
        Link invoiceDetailsLink = linkTo(methodOn(InvoiceDetailsController.class).allInvoiceDetailsByInvoiceId(invoice.getInvoiceId())).withRel("invoice-details");
        return new EntityModel<>(invoice, link,invoiceDetailsLink);
    }
}
