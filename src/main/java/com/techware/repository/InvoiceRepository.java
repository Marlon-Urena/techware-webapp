package com.techware.repository;

import com.techware.model.Invoice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface InvoiceRepository extends CrudRepository<Invoice,Integer> {
    public List<Invoice> findAllByBuyerId_UserAccountId(Integer buyerId);
//    public Optional<Invoice> findBy(Integer buyerId);
}
