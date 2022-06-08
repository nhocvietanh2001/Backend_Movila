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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookingService {

    @Autowired
    public BookingRepository bookingRepository;
    @Autowired
    public RoomRepository roomRepository;
    @Autowired
    public UserRepository userRepository;



    public Set<Booking> InsertBooking(Booking booking) {
        try
        {
            Set<Booking> bookingSet = new HashSet<>();
            User user = userRepository.findById(Long.valueOf(booking.getUid())).get();
            Room room = roomRepository.findById(Long.valueOf(booking.getRid())).get();
            booking.setUser_booking(user);
            booking.setBooked_room(room);
            bookingRepository.save(booking);
            bookingSet.add(booking);
            return bookingSet;
        }
        catch (Exception e){
            return new HashSet<>();
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
    public Set<Booking> UpdateBooking(Booking booking, Long uid) {
            try{
                Booking updatingBooking = bookingRepository.findByUserID(uid);

                Set<Booking> bookingSet = new HashSet<>();
                User user = userRepository.findById(Long.valueOf(booking.getUid())).get();
                Room room = roomRepository.findById(Long.valueOf(booking.getRid())).get();

                booking.setId(updatingBooking.getId());
                booking.setUser_booking(user);
                booking.setBooked_room(room);

                bookingRepository.save(booking);

                bookingSet.add(booking);
                return bookingSet;
            }
            catch (Exception e){
                return new HashSet<>();
            }
    }
}

