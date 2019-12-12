package com.techware.services.implementation;

import com.techware.assembler.UserAccountResourceAssembler;
import com.techware.exceptions.EmailExistsException;
import com.techware.exceptions.InvalidLoginCredentialsException;
import com.techware.exceptions.UserAccountNotFoundException;
import com.techware.model.UserAccount;
import com.techware.repository.UserAccountRepository;
import com.techware.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class UserAccountServiceImpl implements UserAccountService {
    @Autowired
    private final UserAccountRepository repository;
    @Autowired
    private final UserAccountResourceAssembler assembler;

    static String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";


    public UserAccountServiceImpl(UserAccountRepository repository, UserAccountResourceAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @Override
    public EntityModel<UserAccount> findByUserAccountId(Integer userAccountId) {
        UserAccount userAccount = repository.findById(userAccountId).orElseThrow(() -> new UserAccountNotFoundException(userAccountId));
        return assembler.toModel(userAccount);
    }

    @Override
    public ResponseEntity<UserAccount> addUserAccount(UserAccount newUserAccount) {
        newUserAccount.setPasswordHash(encrypt(newUserAccount.getPassword()));
        //repository.findByEmail(newUserAccount.getEmail()).ifPresent(userAccount -> {throw new EmailExistsException(userAccount.getEmail());} ); //Gotta figure out better implementation. Maybe create new HTTP Code or seperate implementation
        repository.findByUsername(newUserAccount.getUsername()).ifPresent(userAccount -> {throw new EmailExistsException(userAccount.getUsername());} );

        EntityModel<UserAccount> entity = assembler.toModel(repository.save(newUserAccount));
        return ResponseEntity.created(URI.create("/useraccount/" + entity.getContent().getUserAccountId())).build();
    }

    @Override
    public ResponseEntity<UserAccount> updateUserAccountById(UserAccount newUserAccount, Integer userAccountId) {
        UserAccount updatedUserAccount = repository.findById(userAccountId)
                .map(userAccount -> {
                    newUserAccount.setPasswordHash(userAccount.getPasswordHash());
                    UserAccount.UserAccountBuilder userAccountBuilder = newUserAccount.toBuilder();
                    userAccount = userAccountBuilder.userAccountId(userAccountId).build();
                    return repository.save(userAccount);
                }).orElseThrow(() -> new UserAccountNotFoundException(userAccountId));
        return ResponseEntity.ok(updatedUserAccount);
    }

    @Override
    public ResponseEntity<UserAccount> deleteUserAccountById(Integer userAccountId) {
        repository.deleteById(userAccountId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<UserAccount> findByUsernameAndPassword(String username, String password) {
        UserAccount userAccount = repository.findByEmailOrUsername(username,username)
                .map(checkUserAccount -> {
                    if (BCrypt.checkpw(password,checkUserAccount.getPasswordHash())) {
                        return checkUserAccount;
                    }
                    else {
                        throw new InvalidLoginCredentialsException();
                    }
                }
        ).orElseThrow(() -> new UserAccountNotFoundException(username));
        return ResponseEntity.ok(userAccount);
        //userAccount = repository.findByEmailOrUsernameAndPasswordHash(username, password);
    }

    public Boolean validatePassword(String password) {
        if(password.matches(pattern)) {
            return true;
        }
        return false;
    }

    private String encrypt(String password) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(password,salt);
    }
}
