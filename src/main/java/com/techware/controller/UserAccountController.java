package com.techware.controller;

import com.techware.model.UserAccount;
import com.techware.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @CrossOrigin(origins = "https://localhost:8443")
@RequestMapping("/api/v1")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @PostMapping(path="/signup")
    public ResponseEntity<UserAccount> newUserAccount (@RequestBody UserAccount newUser) {
        return userAccountService.addUserAccount(newUser);
    }

    @GetMapping(path="/myaccount")
    public EntityModel<UserAccount> one(@RequestParam(value="useraccountId") Integer userAccountId) {
        return userAccountService.findByUserAccountId(userAccountId);
    }

    @PostMapping(path="/login")
    public ResponseEntity<UserAccount> userAccountLogin(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        return userAccountService.findByUsernameAndPassword(username,password);
    }

    @DeleteMapping(path="/myaccount/closeaccount")
    public ResponseEntity<UserAccount> deleteUserAccount(@RequestParam(name="useraccountId") Integer id) {
        return userAccountService.deleteUserAccountById(id);
    }

    @PutMapping(path="/myaccount/account-information")
    public ResponseEntity<UserAccount> replaceUserAccount(@RequestBody UserAccount newUserAccount, @RequestParam(name="useraccountId") Integer id) {
        return userAccountService.updateUserAccountById(newUserAccount, id);
    }

    @PostMapping(path = "/password-validate")
    public ResponseEntity<UserAccount> validatePassword(@RequestParam(name = "password")String password) {
        if(userAccountService.validatePassword(password)) {
            return ResponseEntity.status(HttpStatus.CONTINUE).build();
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
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
