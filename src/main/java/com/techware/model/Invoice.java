package com.techware.model;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class Invoice {
    private @Id @GeneratedValue Integer id;
    private Integer buyerID;
    private Integer sellerID;
    private LocalDateTime transactionDate;
    private LocalDateTime deliveryDate;
    private Integer deliveryAddressID;
    private Integer paymentMethodID;
    private LocalDate requiredDate;
    private BigDecimal totalPrice;

    Invoice() { }

}
