package com.example.MovilaApplication.Controllers;

import com.example.MovilaApplication.Models.ResponseObject;
import com.example.MovilaApplication.Models.User;
import com.example.MovilaApplication.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("")
    //Get all Users
    ResponseEntity<ResponseObject> findAllUser(){
        return userService.findAllUser();
    }
    // Get user by ID
    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }

    // Add new user
    @PostMapping("/new-user")
    ResponseEntity<ResponseObject> addNewUser(@RequestBody User newUser){
        return userService.addNewUser(newUser);
    }

    // Update user
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateUser(@RequestBody User newUser, @PathVariable Long id){
        return userService.updateUser(newUser, id);
    }
    // Delete user
    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }


}
