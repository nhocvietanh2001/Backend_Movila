package com.example.MovilaApplication.Controllers;

import com.example.MovilaApplication.Models.Bill;
import com.example.MovilaApplication.Models.Booking;
import com.example.MovilaApplication.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/bookings")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/InsertBooking")
    Set<Booking> InsertBooking(@RequestBody Booking booking){
        return bookingService.InsertBooking(booking);
    }

    @DeleteMapping("/DeleteBooking/bills/{bid}")
    Integer DeleteBooking(@PathVariable Integer bid){
        return bookingService.DeleteBooking(bid);
    }

    @PutMapping("/UpdateBooking/users/{uid}")
    Set<Booking> UpdateBooking(@RequestBody Booking booking, @PathVariable Long uid){
        return bookingService.UpdateBooking(booking, uid);
    }
}
