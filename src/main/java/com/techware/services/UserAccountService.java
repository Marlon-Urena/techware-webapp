package com.techware.services;

import com.techware.model.UserAccount;
import org.h2.engine.User;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

public interface UserAccountService {
    public abstract EntityModel<UserAccount> findByUserAccountId(Integer id);
    public abstract ResponseEntity<UserAccount> addUserAccount(UserAccount newUserAccount);
    public abstract ResponseEntity<UserAccount> updateUserAccountById(UserAccount newUserAccount, Integer id);
    public abstract ResponseEntity<UserAccount> deleteUserAccountById(Integer id);
    public abstract ResponseEntity<UserAccount> findByUsernameAndPassword(String username, String password);
    public abstract Boolean validatePassword(String password);

}
