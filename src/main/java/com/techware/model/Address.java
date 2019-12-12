package com.techware.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer addressId;

/*
    @ManyToOne(targetEntity = UserAccount.class, fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_account_id", nullable = false)
    private Integer userAccountId;
*/

    private String streetAddress;
    private String postCode;
    private String state;
    private String city;
    private String country;
}
