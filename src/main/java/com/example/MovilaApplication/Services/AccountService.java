package com.example.MovilaApplication.Services;

import com.example.MovilaApplication.Models.Account;
import com.example.MovilaApplication.Models.Hotel;
import com.example.MovilaApplication.Models.ResponseObject;
import com.example.MovilaApplication.Models.User;
import com.example.MovilaApplication.Repositories.AccountRepository;
import com.example.MovilaApplication.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserService userService;

    @Autowired
    HotelService hotelService;

    public List<Optional<Account>> Validate(String username, String password) {
        Optional<Account> foundAccount = accountRepository.findAccountByUsernameAndPassword(username, password);
        List<Optional<Account>> accounts = new ArrayList<>();
        accounts.add(foundAccount);
        return accounts;
    }

    public List<Account> Register(Account newAccount, User newUser) {
        Optional<Account> foundAccount = accountRepository.findAccountByUsername(newAccount.getUsername());

        if (foundAccount.isPresent()) {
            return null;
        }
        else {
            newAccount.setUser(newUser);
            newUser.setAccount(newAccount);
            userService.addNewUser(newUser);
            accountRepository.save(newAccount);
            List<Account> accounts = new ArrayList<>();
            accounts.add(newAccount);
            return accounts;
        }
    }

    public List<Account> RegisterHotel(Account newAccount, Hotel newHotel) {
        Optional<Account> foundAccount = accountRepository.findAccountByUsername(newAccount.getUsername());

        if (foundAccount.isPresent()) {
            return null;
        }
        else {
            newAccount.setHotelaccount(newHotel);
            newHotel.setAccount(newAccount);
            hotelService.addHotel(newHotel);
            accountRepository.save(newAccount);
            List<Account> accounts = new ArrayList<>();
            accounts.add(newAccount);
            return accounts;
        }
    }

    //Note: Update by username. Only update password, userID and role. Unable to update username.
    public Optional<Account> Update(Account account, Long id) {

        Boolean exists = accountRepository.existsById(id);
        if (exists) {
            Optional<Account> foundAccount = accountRepository.findById(id);
            foundAccount.map(updateAccount -> {
                updateAccount.setPassword(account.getPassword());

                return accountRepository.save(updateAccount);
            });
            return foundAccount;
        }
        return null;
    }

    //Note: Delete by username, and have to validate the account before deleting.
    public ResponseEntity<ResponseObject> Delete(Account account){
        Optional<Account> foundAccount = accountRepository.findAccountByUsernameAndPassword(account.getUsername(), account.getPassword());
        if (foundAccount.isPresent()) {
            accountRepository.deleteById(foundAccount.get().getId());
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("200", "Delete account successfully", "")
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("404", "Account not found", "")
            );
        }
    }

    public List<Account> getAllUserAccount() {
        List<Account> accounts = accountRepository.findAllAccountByRole("user");
        return accounts;
    }

    public List<Account> getAllHotelAccount() {
        List<Account> accounts = accountRepository.findAllAccountByRole("hotel");
        return accounts;
    }
}
