package com.techware.services;

import com.techware.model.Product;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    public abstract EntityModel<Product> getProductById(Integer id);
    public abstract CollectionModel<EntityModel<Product>> getAllProducts();
    public abstract ResponseEntity<Product> addProduct(Product newProduct);
    public abstract ResponseEntity<Product> updateProductById(Product newProduct, Integer id);
    public abstract ResponseEntity<Product> deleteProductById(Integer id);
    public abstract CollectionModel<EntityModel<?>> getAllProductsByUserAccountId(Integer userAccountId);
}
