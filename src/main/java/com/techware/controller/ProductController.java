package com.techware.controller;

import com.techware.model.Product;
import com.techware.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "https://localhost:8443")
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(path="/product/sell")
    public ResponseEntity<Product> addProduct(@RequestBody Product newProduct) {
        return productService.addProduct(newProduct);
    }

    @GetMapping(path="/product")
    public EntityModel<Product> one(@RequestParam(value = "productId") Integer productId) {
        return productService.getProductById(productId);
    }

    @GetMapping(path = "/search")
    public CollectionModel<EntityModel<Product>> query() {
        return productService.getAllProducts();
    }

    @GetMapping(path = "/myaccount/inventory")
    public CollectionModel<EntityModel<?>> allProductsFromUserAccount(@RequestParam(value = "useraccountId") Integer userAccountId) {
        return productService.getAllProductsByUserAccountId(userAccountId);
    }

    @PutMapping(path="/product/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product newProduct, @RequestParam(name = "productId") Integer productId) {
       return productService.updateProductById(newProduct, productId);
    }

    @DeleteMapping(path="/product/remove")
    public ResponseEntity<Product> deleteProduct(@RequestParam(name="productId")Integer productId) {
        return productService.deleteProductById(productId);
    }
}

