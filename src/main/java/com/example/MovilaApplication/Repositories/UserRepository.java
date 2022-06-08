package com.example.MovilaApplication.Repositories;

import com.example.MovilaApplication.Models.Bill;
import com.example.MovilaApplication.Models.Room;
import com.example.MovilaApplication.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //@Query("SELECT u FROM User u WHERE u.mail = ?1")
    Optional<User> findByMail(String Mail);

    @Query("SELECT u.billList From User u Where u.id = ?1")
    List<Bill> GetBillsById(long uid);

}
