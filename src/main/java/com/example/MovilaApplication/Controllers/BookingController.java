package com.example.MovilaApplication.Controllers;


import com.example.MovilaApplication.Models.Bill;
import com.example.MovilaApplication.Models.Booking;
import com.example.MovilaApplication.Models.Room;
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

    @GetMapping("/notbooked")
    List<Room> GetRoomAvailable() {
        return bookingService.getAllRoomAvailable();
    }

    @GetMapping("/notbooked/{hid}")
    List<Room> GetRoomAvailable(@PathVariable Long hid) {
        return bookingService.getRoomAvailable(hid);
    }

    @GetMapping("/booked/{hid}")
    List<Room> GetRoomUnavailable(@PathVariable Long hid) {
        return bookingService.getRoomUnavailable(hid);
    }

    @GetMapping("/hotels/{hid}")
    List<Booking> GetBookingByHotel(@PathVariable Long hid) {
        return bookingService.getBookingByHotel(hid);
    }

    @GetMapping("/users/{uid}")
    List<Booking> GetBookingByUser(@PathVariable Long uid) {
        return bookingService.getBookingByUser(uid);
    }

    @PostMapping("rooms/{rid}/users/{uid}")
    Set<Booking> InsertBooking(@RequestBody Booking booking, @PathVariable Long rid, @PathVariable Long uid){
        return bookingService.InsertBooking(booking, rid, uid);
    }

    @DeleteMapping("/validate/{bookingid}")
    List<Bill> DeleteBookingAndInsertBill(@PathVariable Long bookingid){
        return bookingService.DeleteBookingAndInsertBill(bookingid);
    }

    @DeleteMapping("/cancel/{bookingid}")
    Boolean CancelBooking(@PathVariable Long bookingid){
        return bookingService.CancelBooking(bookingid);
    }
}
