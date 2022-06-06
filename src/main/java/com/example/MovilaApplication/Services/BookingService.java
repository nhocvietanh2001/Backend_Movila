package com.example.MovilaApplication.Services;

import com.example.MovilaApplication.Models.Booking;
import com.example.MovilaApplication.Models.Room;
import com.example.MovilaApplication.Models.User;
import com.example.MovilaApplication.Repositories.BookingRepository;
import com.example.MovilaApplication.Repositories.RoomRepository;
import com.example.MovilaApplication.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    public BookingRepository bookingRepository;
    public RoomRepository roomRepository;
    public UserRepository userRepository;
    public List<Booking> GetUserBookings(Integer uid) {
        return bookingRepository.findBookingByUid(uid);
    }

    public Boolean InsertBooking(Booking booking) {
        if(booking == null){
            return false;
        }
        else{
            try{
                User user = userRepository.findById(Long.valueOf(booking.getUid())).get();
                Room room = roomRepository.findById(Long.valueOf(booking.getRid())).get();
                booking.setUser_booking(user);
                booking.setBooked_room(room);
                bookingRepository.save(booking);
                return true;
            }
            catch (Exception e){
                return false;
            }
        }
    }

    public Boolean DeleteBooking(Integer bid) {
        try{
            bookingRepository.deleteBooking(bid);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public Boolean UpdateBooking(Booking booking) {
        if(booking == null){
            return false;
        }
        else{
            try{
                User user = userRepository.findById(Long.valueOf(booking.getUid())).get();
                Room room = roomRepository.findById(Long.valueOf(booking.getRid())).get();
                booking.setUser_booking(user);
                booking.setBooked_room(room);
                bookingRepository.save(booking);
                return true;
            }
            catch (Exception e){
                return false;
            }
        }
    }
}
