package com.techware.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class Invoice {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "buyer_id", nullable = false)
    @JsonIgnore
    private Integer buyerID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "seller_id", nullable = false)
    @JsonIgnore
    private Integer sellerID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false,  cascade = CascadeType.REMOVE)
    @JoinColumn(name = "delivery_address_id", nullable = false)
    @JsonIgnore
    private Integer deliveryAddressID;

    private LocalDateTime transactionDate;
    private LocalDateTime deliveryDate;
    //private Integer paymentMethodID;
    private LocalDate requiredDate;
    private BigDecimal totalPrice;

    Invoice() { }

}
