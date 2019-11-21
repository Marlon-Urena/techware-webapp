package com.techware.controller;

import com.techware.exceptions.UserAccountNotFoundException;
import com.techware.repository.UserAccountRepository;
import com.techware.UserAccountResourceAssembler;
import com.techware.model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1")
public class UserAccountController {
    @Autowired
    private final UserAccountRepository repository;
    private final UserAccountResourceAssembler assembler;

    UserAccountController(UserAccountRepository repository, UserAccountResourceAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @PostMapping(path="/signup") // Map ONLY POST Requests
    public UserAccount newUserAccount (@RequestBody UserAccount newUser) {
        return repository.save(newUser);
    }

    @GetMapping(path="/useraccount/{id}")
    public EntityModel<UserAccount> one(@PathVariable Integer id) {
        UserAccount userAccount = repository.findById(id).orElseThrow(() -> new UserAccountNotFoundException(id));
        return assembler.toModel(userAccount);
    }

    @PostMapping(path="/login")
    public ResponseEntity<UserAccount> userAccountLogin() {
        //Will be utilizing authentication tokens here
    }

    @DeleteMapping(path="/closeaccount/{id}")
    public ResponseEntity<UserAccount> deleteUserAccount(@RequestBody UserAccount userAccountToDelete, @PathVariable Integer id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path="/myaccount/{id}")
    public ResponseEntity<UserAccount> replaceUserAccount(@RequestBody UserAccount newUserAccount, @PathVariable Integer id) {
        UserAccount updatedUserAccount = repository.findById(id)
                .map(userAccount -> {
                    userAccount = newUserAccount.toBuilder().build();
                    return repository.save(userAccount);
                })
                .orElseGet(() -> {
                    newUserAccount.setId(id);
                    return repository.save(newUserAccount);
                });
        return ResponseEntity.ok(updatedUserAccount);
    }

}
/*
-I may be going about this web application incorrectly.
-It seems that I have to perform
 functionality on the backend to handle objectives such as validation and error handling.
-Must take a look at how to create a web application and possibly look at examples such as login systems (although those types of examples may be crap)
-Gotta see how to handle end points for HTTP requests.
-Look at other web applications to get a better idea of how web applications work.
-Make sure to include validators to check for correctness ( Spring includes a validator)
 */