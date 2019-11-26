package com.techware.controller;

import com.techware.assembler.ProductResourceAssembler;
import com.techware.exceptions.ProductNotFoundException;
import com.techware.model.Product;
import com.techware.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @CrossOrigin(origins = "https://localhost:8443")
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductRepository repository;
    private final ProductResourceAssembler assembler;

    ProductController(ProductRepository repository, ProductResourceAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @PostMapping(path="/sell")
    public Product addProduct(@RequestBody Product newProduct) {
        return repository.save(newProduct);
    }

    @GetMapping
    public EntityModel<Product> one(@RequestParam(value = "id") Integer id) {
        Product product = repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        return assembler.toModel(product);
    }

    @PutMapping(path="/update")
    public ResponseEntity<Product> replaceProduct(@RequestBody Product newProduct, @RequestParam(name = "id") Integer id) {
        Product updatedProduct = repository.findById(id)
                .map(product -> {
                    Product.ProductBuilder productBuilder = newProduct.toBuilder();
                    product = productBuilder.productId(id).build();
                    return repository.save(product);
                })
                .orElseGet(() -> {
                    newProduct.setProductId(id);
                    return repository.save(newProduct);
                });
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping(path="/remove")
    public ResponseEntity<Product> deleteProduct(@RequestParam(name="id")Integer id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

