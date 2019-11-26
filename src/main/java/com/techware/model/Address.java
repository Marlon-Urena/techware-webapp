package com.techware.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer addressId;

    @ManyToOne(targetEntity = UserAccount.class,fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REMOVE)
    @JoinColumn(name="user_account_id")
    private Integer userAccountId;

    private String streetAddress;
    private String postCode;
    private String state;
    private String city;
    private String country;

    Address() {}
}
