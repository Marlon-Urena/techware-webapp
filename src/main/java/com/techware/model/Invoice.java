package com.techware.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer invoiceId;

    @ManyToOne(targetEntity = UserAccount.class, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "buyer_id", nullable = false,updatable = false, insertable = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY, value = "buyer")
    private UserAccount buyerId;

    @ManyToOne(targetEntity = UserAccount.class, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "seller_id", nullable = false, updatable = false, insertable = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY, value = "seller")
    private UserAccount sellerId;

    @ManyToOne(targetEntity = Address.class, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "delivery_address_id", nullable = false,updatable = false, insertable = true)
    @JsonProperty(value = "deliverAddress")
    private Address deliveryAddressId;

    private LocalDate transactionDate; //May change to LocalDate
    private LocalDate deliveryDate;
    private LocalDate expectedReturnDate;
    //private Integer paymentMethodID;
    private BigDecimal totalPrice;
}
