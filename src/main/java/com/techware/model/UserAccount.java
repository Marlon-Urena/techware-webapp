package com.techware.model;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class UserAccount {
    private @Id @GeneratedValue Integer id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String phoneNumber;

    UserAccount() {}

    UserAccount(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
