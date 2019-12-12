package com.techware.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name="user_account")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userAccountId;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    @NotNull
    private String username;

    @NotNull
    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotNull
    @JsonIgnore
    private String passwordHash;

//    @NotNull
//    @JsonIgnore
//    private String salt;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "invoice")
//    private List<Invoice> invoices;

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String phoneNumber;

    public UserAccount(Integer userAccountId) {
        this.userAccountId = userAccountId;
    }
}
