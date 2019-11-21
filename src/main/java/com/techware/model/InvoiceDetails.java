package com.techware.model;
import lombok.Data;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

@Data
@Entity(name = "invoice_details")
public class InvoiceDetails {
    @Id
    @ManyToOne(fetch = FetchType.LAZY,optional = false, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "product_id", nullable = false)
    @JsonIgnore
    private Integer productId;

    @Id
    @ManyToOne(fetch = FetchType.LAZY,optional = false, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "invoice_id", nullable = false)
    @JsonIgnore
    private Integer invoiceId;

    private Integer quantity;
    private BigDecimal itemsPrice;

    InvoiceDetails() { }


}
