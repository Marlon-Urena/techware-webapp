package com.techware.model;
import lombok.Data;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.type.BigDecimalType;

import java.math.BigDecimal;
import java.sql.Clob;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "seller_id", nullable = false)
    @JsonIgnore
    private Integer sellerId;

    private BigDecimal rentalPrice;
    private BigDecimal price;
    private BigDecimal weightInPounds;
    private BigDecimal sizeInInches;
    private Integer color; //Must support multiple colors
    private String imagePath;
    private String title;
    private Clob description;
    private Boolean available;
    private Integer quantityStock;
    private Integer quantityOrdered;
    private Integer quantityRented;

    Product() {}

    Product(Integer sellerId, BigDecimal rentalPrice, BigDecimal price, BigDecimal weightInPounds, BigDecimal sizeInInches, Integer color, String imagePath, String title, Clob description, Boolean available, Integer quantityStock, Integer quantityOrdered, Integer quantityRented ){

    }
}
