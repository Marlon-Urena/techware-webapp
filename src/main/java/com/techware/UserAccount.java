package com.techware;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class UserAccount {
    private @Id @GeneratedValue Integer id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Date
}
