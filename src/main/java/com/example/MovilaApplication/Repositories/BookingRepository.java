package com.example.MovilaApplication.Repositories;

import com.example.MovilaApplication.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Booking b WHERE b.id = ?1")
    Integer deleteBooking(Integer booking_id);

    @Query("SELECT b FROM Booking b WHERE b.uid = ?1")
    Booking findByUserID(Long uid);
}
