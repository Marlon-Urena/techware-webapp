package com.techware.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@Builder(toBuilder = true)

public class Address {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_account_id", nullable = false)
    @JsonIgnore
    private Integer accountID;

    private String streetAddress;
    private String postCode;
    private String state;
    private String city;
    private String country;

    Address() {}

//    Address(Integer accountID, String streetAddress, String postCode, String state, String city, String country) {
//        this.accountID = accountID;
//        this.streetAddress = streetAddress;
//        this.postCode = postCode;
//        this.state = state;
//        this.city = city;
//        this.country = country;
//
//    }
}
