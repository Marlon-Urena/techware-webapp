package com.techware.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@AllArgsConstructor
public class InvoiceCreationRequest {
//    private Invoice invoice;
//    private List<InvoiceDetails> invoiceDetails;
    private Integer productId;
    private Integer sellerId;
    private Integer buyerId;
    private Integer addressId;
}
