package com.example.MovilaApplication.Services;

import com.example.MovilaApplication.Models.Booking;
import com.example.MovilaApplication.Models.Room;
import com.example.MovilaApplication.Models.User;
import com.example.MovilaApplication.Repositories.BookingRepository;
import com.example.MovilaApplication.Repositories.RoomRepository;
import com.example.MovilaApplication.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    public BookingRepository bookingRepository;
    @Autowired
    public RoomRepository roomRepository;
    @Autowired
    public UserRepository userRepository;



    public Boolean InsertBooking(Booking booking) {
        try
        {
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
    @Transactional
    @Modifying
    public Integer DeleteBooking(Integer bid) {
        try{
            return bookingRepository.deleteBooking(bid);
        }
        catch (Exception e){
            return 0;
        }
    }
    // Update the room id and the user id
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
