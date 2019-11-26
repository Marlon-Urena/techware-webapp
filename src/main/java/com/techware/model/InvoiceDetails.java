package com.techware.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@Builder(toBuilder = true)
@IdClass(InvoiceDetailsId.class)
@Table(name = "invoice")
public class InvoiceDetails {
    private InvoiceDetailsId invoiceDetailsId;

    private Integer quantity;
    private BigDecimal itemsPrice;

    InvoiceDetails() { }
}
