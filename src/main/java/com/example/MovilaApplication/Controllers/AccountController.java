package com.example.MovilaApplication.Controllers;

import com.example.MovilaApplication.Models.Account;
import com.example.MovilaApplication.Models.ResponseObject;
import com.example.MovilaApplication.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/login")
    Optional<Account> Validate(@RequestParam String username, @RequestParam String password, @RequestParam String role) {
        Account a = new Account(username, password, role);
        return accountService.Validate(a.getUsername(), a.getPassword());
    }

    @PostMapping("/register")
    ResponseEntity<ResponseObject> Register(@RequestBody Account account) {
        return accountService.Register(account);
    }

    @PutMapping("/update")
    ResponseEntity<ResponseObject> Update(@RequestBody Account account) {
        return accountService.Update(account);
    }

    @DeleteMapping("/delete")
    ResponseEntity<ResponseObject> Delete(@RequestBody Account account) {
        return accountService.Delete(account);
    }

}
