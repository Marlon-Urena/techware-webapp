package com.techware.services.implementation;

import com.techware.assembler.ProductResourceAssembler;
import com.techware.exceptions.ProductNotFoundException;
import com.techware.model.Product;
import com.techware.repository.ProductRepository;
import com.techware.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private final ProductRepository repository;
    @Autowired
    private final ProductResourceAssembler assembler;

    public ProductServiceImpl(ProductRepository repository, ProductResourceAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @Override
    public EntityModel<Product> getProductById(Integer productId) {
        Product product = repository.findById(productId).orElseThrow(() -> new ProductNotFoundException(productId));
        return assembler.toModel(product);
    }

    @Override
    public CollectionModel<EntityModel<Product>> getAllProducts() {
        List<EntityModel<Product>> products = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return new CollectionModel<>(products);
    }

    @Override
    public ResponseEntity<Product> addProduct(Product newProduct) {
        EntityModel<Product> entity = assembler.toModel(repository.save(newProduct));
        //Link link = linkTo(methodOn(ProductController.class).one(entity.getContent().getProductId())).withSelfRel();

        return ResponseEntity.created(URI.create("/product/" + entity.getContent().getProductId())).build();
    }

    @Override
    public ResponseEntity<Product> updateProductById(Product newProduct, Integer productId) {
        Product updatedProduct = repository.findById(productId)
                .map(product -> {
                    Product.ProductBuilder productBuilder = newProduct.toBuilder();
                    product = productBuilder.productId(productId).build();
                    return repository.save(product);
                })
                .orElseGet(() -> {
                    newProduct.setProductId(productId);
                    return repository.save(newProduct);
                });
        return ResponseEntity.ok(updatedProduct);
    }

    @Override
    public ResponseEntity<Product> deleteProductById(Integer productId) {
        repository.deleteById(productId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public CollectionModel<EntityModel<?>> getAllProductsByUserAccountId(Integer userAccountId) {
        List<EntityModel<?>> products = repository.findAllBySellerId_UserAccountId(userAccountId).stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return new CollectionModel<>(products);
    }
}
