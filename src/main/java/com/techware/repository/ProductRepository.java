package com.techware.repository;

import com.techware.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    public List<Product> findAllBySellerId_UserAccountId(Integer sellerId);
    public Product findByProductId(Integer productId);
}
