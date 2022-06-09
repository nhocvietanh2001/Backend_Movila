package com.example.MovilaApplication.Services;

import com.example.MovilaApplication.Models.Booking;
import com.example.MovilaApplication.Models.Room;
import com.example.MovilaApplication.Models.User;
import com.example.MovilaApplication.Repositories.BookingRepository;
import com.example.MovilaApplication.Repositories.HotelRepository;
import com.example.MovilaApplication.Repositories.RoomRepository;
import com.example.MovilaApplication.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;

@Service
public class BookingService {

    @Autowired
    public BookingRepository bookingRepository;
    @Autowired
    public RoomRepository roomRepository;
    @Autowired
    public UserRepository userRepository;
    @Autowired
    HotelRepository hotelRepository;

    public Set<Booking> InsertBooking(Booking booking, Long rid, Long uid) {
        try
        {
            Set<Booking> bookingSet = new HashSet<>();
            Optional<Booking> foundBooking = bookingRepository.findBookingByRidAndUid(rid, uid);
            if (foundBooking.isPresent()) {
                bookingSet.add(foundBooking.get());
                return bookingSet;
            }

            User user = userRepository.findById(uid).get();
            Room room = roomRepository.findById(rid).get();
            LocalDate now = LocalDate.now();
            booking.setCheckinDate(now);
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

    public List<Room> getRoomAvailable(Long hid) {
        List<Room> rooms = hotelRepository.getRoomsById(hid);
        List<Booking> bookings = bookingRepository.findAll();
        List<Room> unavailableRooms = new ArrayList<>();
        for (Booking booking : bookings) {
            unavailableRooms.add(booking.getBooked_room());
        }
        rooms.removeAll(unavailableRooms);
        return rooms;
    }

    public List<Room> getRoomUnavailable(Long hid) {
        List<Room> rooms = hotelRepository.getRoomsById(hid);
        List<Room> result = hotelRepository.getRoomsById(hid);

        List<Booking> bookings = bookingRepository.findAll();
        List<Room> unavailableRooms = new ArrayList<>();
        for (Booking booking : bookings) {
            if (booking.getBooked_room()!=null)
                unavailableRooms.add(booking.getBooked_room());
        }
        rooms.removeAll(unavailableRooms);
        result.removeAll(rooms);
        return result;
    }

    public List<Booking> getBookingByHotel(Long hid) {
        List<Booking> bookings = bookingRepository.findBookingByHotel(hid);
        return bookings;
    }

    public List<Booking> getBookingByUser(Long uid) {
        List<Booking> bookings = bookingRepository.findBookingByUser(uid);
        return bookings;
    }
}

