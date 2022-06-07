package com.example.MovilaApplication.Controllers;

import com.example.MovilaApplication.Models.Bill;
import com.example.MovilaApplication.Models.ResponseObject;
import com.example.MovilaApplication.Models.User;
import com.example.MovilaApplication.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("")
    //Get all Users
    List<User> findAllUser(){
        return userService.findAllUser();
    }
    // Get user by ID
    @GetMapping("/{id}")
    Optional<User> findUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }

    // Get User Bill List
    @GetMapping(path = "/GetUserBills/{uid}")
    Set<Bill> GetUserBills(@PathVariable Long uid){
        return userService.GetUserBills(uid);
    }
    // Add new user
    @PostMapping("/new-user")
    Boolean addNewUser(@RequestBody User newUser){
        return userService.addNewUser(newUser);
    }

    // Update user
    @PutMapping("/{id}")
    Optional<User> updateUser(@RequestBody User newUser, @PathVariable Long id){
        return userService.updateUser(newUser, id);
    }
    // Delete user
    @DeleteMapping("/{id}")
    Boolean deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }


}
