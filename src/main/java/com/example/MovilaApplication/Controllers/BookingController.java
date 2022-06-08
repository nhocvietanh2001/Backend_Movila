package com.example.MovilaApplication.Controllers;

import com.example.MovilaApplication.Models.Bill;
import com.example.MovilaApplication.Models.Booking;
import com.example.MovilaApplication.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/bookings")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/InsertBooking")
    Boolean InsertBooking(@RequestBody Booking booking){
        return bookingService.InsertBooking(booking);
    }

    @DeleteMapping("/DeleteBooking/{bid}")
    Integer DeleteBooking(@PathVariable Integer bid){
        return bookingService.DeleteBooking(bid);
    }

    @PutMapping("/UpdateBooking")
    Boolean UpdateBooking(@RequestBody Booking booking){
        return bookingService.UpdateBooking(booking);
    }
}