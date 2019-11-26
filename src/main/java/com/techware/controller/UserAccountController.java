package com.techware.controller;

import com.techware.exceptions.UserAccountNotFoundException;
import com.techware.repository.UserAccountRepository;
import com.techware.assembler.UserAccountResourceAssembler;
import com.techware.model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @CrossOrigin(origins = "https://localhost:8443")
@RequestMapping("/api/v1")
public class UserAccountController {

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

    @GetMapping(path="/useraccount")
    public EntityModel<UserAccount> one(@RequestParam(value="id") Integer id) {
        UserAccount userAccount = repository.findById(id).orElseThrow(() -> new UserAccountNotFoundException(id));
        return assembler.toModel(userAccount);
    }

//    @PostMapping(path="/login")
//    public ResponseEntity<UserAccount> userAccountLogin() {
//        //Will be utilizing authentication tokens here
//    }

    @DeleteMapping(path="/closeaccount")
    public ResponseEntity<UserAccount> deleteUserAccount(@RequestParam(name="id") Integer id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path="/myaccount")
    public ResponseEntity<UserAccount> replaceUserAccount(@RequestBody UserAccount newUserAccount, @RequestParam(name="id") Integer id) {
        UserAccount updatedUserAccount = repository.findById(id)
                .map(userAccount -> {
                    UserAccount.UserAccountBuilder userAccountBuilder = newUserAccount.toBuilder();
                    userAccount = userAccountBuilder.userAccountId(id).build();
                    return repository.save(userAccount);
                })
                .orElseGet(() -> {
                    newUserAccount.setUserAccountId(id);
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
