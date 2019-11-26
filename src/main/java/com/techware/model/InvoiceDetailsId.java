package com.techware.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class InvoiceDetailsId implements Serializable {
    private Integer productId;
    private Integer invoiceId;
}
