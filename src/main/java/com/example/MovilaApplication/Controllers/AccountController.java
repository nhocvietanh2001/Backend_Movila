package com.example.MovilaApplication.Controllers;

import com.example.MovilaApplication.Models.*;
import com.example.MovilaApplication.Repositories.AccountRepository;
import com.example.MovilaApplication.Repositories.UserRepository;
import com.example.MovilaApplication.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping
    List<Account> getAll() {
        List<Account> hotels = accountRepository.findAll();
        return hotels;
    }

    @GetMapping("/login")
    List<Optional<Account>> ValidatePa(@RequestParam String username, @RequestParam String password, @RequestParam String role) {
        Account a = new Account(username, password, role);
        return accountService.Validate(a.getUsername(), a.getPassword());
    }

    @GetMapping("/loginjson")
    List<Optional<Account>> ValidateJ(@RequestBody String username, @RequestBody String password, @RequestBody String role) {
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

    @PutMapping("/{aid}/users/{uid}")
    public Account assignToHotel(@PathVariable Long aid, @PathVariable Long uid) {
        Account account = accountRepository.findById(aid).get();
        User user = userRepository.findById(uid).get();
        account.setUser(user);
        user.setAccount(account);
        userRepository.save(user);
        return accountRepository.save(account);
    }

    @DeleteMapping("/delete")
    ResponseEntity<ResponseObject> Delete(@RequestBody Account account) {
        return accountService.Delete(account);
    }

}
