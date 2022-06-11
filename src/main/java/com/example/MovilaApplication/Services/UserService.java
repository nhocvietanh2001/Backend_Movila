package com.example.MovilaApplication.Services;

import com.example.MovilaApplication.Models.Account;
import com.example.MovilaApplication.Models.Bill;
import com.example.MovilaApplication.Models.Booking;
import com.example.MovilaApplication.Models.ResponseObject;
import com.example.MovilaApplication.Models.User;
import com.example.MovilaApplication.Repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
        accounts.add(foundUser.getAccount().cloneAndRemovePassword());
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
        Boolean exists = userRepository.existsById(id);
        if (exists) {
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
        return null;
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

    public Set<Bill> GetUserBills(Long uid) {
        try{
            User user = userRepository.findById(uid).get();
            return user.getBillList();
        }
       catch (Exception e){
            return null;
       }
    }

    public Set<Booking> GetUserBookings(Long uid) {
        return userRepository.findById(uid).get().getBookingList();
    }
}
