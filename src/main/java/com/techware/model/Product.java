package com.techware.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import javax.persistence.*;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @ManyToOne(targetEntity = UserAccount.class,fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "seller_id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY, value = "seller")
    private UserAccount sellerId;

    private BigDecimal rentalPrice;
    //private BigDecimal price;
    //private BigDecimal weightInPounds;
    private Size size;
    private Color color;
    private String imagePath;
    private String title;

    @Lob @Basic(fetch = FetchType.LAZY)
    @Column(name="description")

    private String description;
    private Boolean available;
    private Integer quantityStock;
    //private Integer quantityOrdered;
    private Integer quantityRented;
}
