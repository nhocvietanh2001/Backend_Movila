package com.example.MovilaApplication.Controllers;


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

    @GetMapping("/notbooked/{hid}")
    List<Room> GetRoomAvailable(@PathVariable Long hid) {
        return bookingService.getRoomAvailable(hid);
    }

    @GetMapping("/booked/{hid}")
    List<Room> GetRoomUnavailable(@PathVariable Long hid) {
        return bookingService.getRoomUnavailable(hid);
    }

    @PostMapping("rooms/{rid}/users/{uid}")
    Set<Booking> InsertBooking(@RequestBody Booking booking, @PathVariable Long rid, @PathVariable Long uid){
        return bookingService.InsertBooking(booking, rid, uid);
    }

    @DeleteMapping("/{bid}")
    Integer DeleteBooking(@PathVariable Integer bid/*, @RequestBody*/ ){
        return bookingService.DeleteBooking(bid);
    }
}
