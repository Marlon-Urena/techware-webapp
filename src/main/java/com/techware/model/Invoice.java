package com.techware.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@Builder(toBuilder = true)
public class Invoice {
    @Id
    @GeneratedValue
    private Integer invoiceId;

    @ManyToOne(targetEntity = UserAccount.class, fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "buyer_id", nullable = false)
    @JsonIgnore
    private Integer buyerId;

    @ManyToOne(targetEntity = UserAccount.class, fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "seller_id", nullable = false)
    @JsonIgnore
    private Integer sellerId;

    @ManyToOne(targetEntity = Address.class, fetch = FetchType.LAZY, optional = false,  cascade = CascadeType.REMOVE)
    @JoinColumn(name = "delivery_address_id", nullable = false)
    @JsonIgnore
    private Integer deliveryAddressId;

    private LocalDateTime transactionDate;
    private LocalDateTime deliveryDate;
    //private Integer paymentMethodID;
    private LocalDate requiredDate;
    private BigDecimal totalPrice;

    Invoice() { }

}
