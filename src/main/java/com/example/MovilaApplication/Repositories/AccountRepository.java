package com.example.MovilaApplication.Repositories;

import com.example.MovilaApplication.Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("SELECT a FROM Account a WHERE a.username = ?1 and a.password = ?2")
    Optional<Account> findAccountByUsernameAndPassword(String username, String password);

    Optional<Account> findAccountByUsername(String username);

    @Query("SELECT a FROM Account a WHERE a.role = ?1")
    List<Account> findAllAccountByRole(String role);
}
