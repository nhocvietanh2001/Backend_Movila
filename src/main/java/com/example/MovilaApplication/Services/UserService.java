package com.example.MovilaApplication.Services;

import com.example.MovilaApplication.Models.Account;
import com.example.MovilaApplication.Models.ResponseObject;
import com.example.MovilaApplication.Models.User;
import com.example.MovilaApplication.Repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUser() {
        List<User> allUser = userRepository.findAll();
        return allUser;
    }

    public List<Optional<User>> findUserById(Long id){
        Optional<User> foundUser = userRepository.findById(id);
        List<Optional<User>> users = new ArrayList<>();
        users.add(foundUser);
        return users;
    }

    public List<Account> findAccountOfUserById(Long id){
        User foundUser = userRepository.findById(id).get();
        List<Account> accounts = new ArrayList<>();
        accounts.add(foundUser.getAccount());
        return accounts;
    }

    public User addNewUser(User newUser){
        Optional<User> UserByMail = userRepository.findByMail(newUser.getMail());
        if (UserByMail.isPresent()) {
            return null;
        } else {
            return userRepository.save(newUser);
        }
    }

    public Optional<User> updateUser(User newUser, Long id){
        Optional<User> UserByMail = userRepository.findByMail(newUser.getMail());
        if (UserByMail.isPresent()) {
            return null;
        } else {
            Optional<User> updateUser = userRepository.findById(id)
                    .map(user -> {
                        user.setFirstName(newUser.getFirstName());
                        user.setLastName(newUser.getLastName());
                        user.setPhone(newUser.getPhone());
                        user.setMail(newUser.getMail());
                        return userRepository.save(user);
                    });
            return updateUser;
        }
    }

    public Boolean deleteUser(Long id){
        boolean isExists = userRepository.existsById(id);
        if(isExists){
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
