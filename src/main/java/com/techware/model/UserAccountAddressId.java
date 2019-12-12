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
public class UserAccountAddressId implements Serializable {
    private Integer userAccountId;
    private Integer addressId;
}
