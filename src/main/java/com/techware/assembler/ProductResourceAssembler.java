package com.techware.assembler;

import com.techware.controller.ProductController;
import com.techware.model.Product;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ProductResourceAssembler implements RepresentationModelAssembler<Product, EntityModel<Product>> {

    @Override
    public EntityModel<Product> toModel(Product product) {
        Link link = linkTo(methodOn(ProductController.class).one(product.getProductId())).withSelfRel();
        return new EntityModel<Product>(product, link);
    }
}
