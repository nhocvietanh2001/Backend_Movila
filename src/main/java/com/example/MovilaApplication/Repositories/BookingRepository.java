package com.example.MovilaApplication.Repositories;

import com.example.MovilaApplication.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    @Query("SELECT b FROM Booking b WHERE b.uid = ?1")
    List<Booking> findBookingByUid(Integer user_id);

    @Query("DELETE FROM Booking b WHERE b.id = ?1")
    Boolean deleteBooking(Integer booking_id);
}
