package com.example.MovilaApplication.Repositories;

import com.example.MovilaApplication.Models.Booking;
import com.example.MovilaApplication.Models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
//    @Query("SELECT a FROM Contact a WHERE a.user_contact.id = ?1")
//    List<Contact> findContactByUser(Long uid);
}
