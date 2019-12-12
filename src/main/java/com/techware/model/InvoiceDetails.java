package com.techware.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class InvoiceDetails {
    @EmbeddedId
    @JsonProperty(value = "invoiceDetails")
    private InvoiceDetailsId invoiceDetailsId;

    //private Integer quantity;
    //private BigDecimal itemsPrice;
}
