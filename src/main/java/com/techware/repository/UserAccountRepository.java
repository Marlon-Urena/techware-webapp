package com.techware.repository;

import com.techware.model.UserAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserAccountRepository extends CrudRepository<UserAccount, Integer> {
    public Optional<UserAccount> findByEmailOrUsername(String email, String password);
    public Optional<UserAccount> findByEmail(String email);
    public Optional<UserAccount> findByUsername(String username);
    public UserAccount findByUserAccountId(Integer userAccountId);
   // public UserAccount findByEmailOrUsernameAndPasswordHash(String username, String passwordHash);

}
