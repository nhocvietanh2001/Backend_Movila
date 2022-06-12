package com.example.MovilaApplication.Pattern;

import com.example.MovilaApplication.Models.Booking;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Calculate {
    static Float calculatePrice(Booking booking, LocalDate checkoutDate) {
        LocalDate checkinDate = booking.getCheckinDate();
        Integer day = Math.toIntExact(ChronoUnit.DAYS.between(checkinDate, checkoutDate)) + 1;
        Float price = Float.valueOf(booking.getBooked_room().getPrice() * day / 10);
        return price;
    }
}
