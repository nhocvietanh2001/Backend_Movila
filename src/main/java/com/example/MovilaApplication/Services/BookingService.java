package com.example.MovilaApplication.Services;

import com.example.MovilaApplication.Models.Bill;
import com.example.MovilaApplication.Models.Booking;
import com.example.MovilaApplication.Models.Room;
import com.example.MovilaApplication.Models.User;
import com.example.MovilaApplication.Repositories.*;
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
    @Autowired
    BillRepository billRepository;

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
    public List<Bill> DeleteBookingAndInsertBill(Long bookingid) {
        try {
            Optional<Booking> booking = bookingRepository.findById(bookingid);

            LocalDate checkoutDate = LocalDate.now();
            Bill bill = new Bill(booking.get().getCheckinDate(), checkoutDate, booking.get().getUser_booking(), booking.get().getBooked_room());

            billRepository.save(bill);
            bookingRepository.deleteById(bookingid);

            List<Bill> bills = new ArrayList<>();
            bills.add(bill);
            return bills;
        }
        catch(Exception e) {
            return null;
        }
    }

    public List<Room> getRoomAvailable(Long hid) {
        List<Room> rooms = hotelRepository.getRoomsById(hid);
        List<Booking> bookings = bookingRepository.findBookingByHotel(hid);
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

        List<Booking> bookings = bookingRepository.findBookingByHotel(hid);
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

    public List<Room> getAllRoomAvailable() {
        List<Room> rooms = roomRepository.findAll();
        List<Booking> bookings = bookingRepository.findAll();
        List<Room> unavailableRooms = new ArrayList<>();
        for (Booking booking : bookings) {
            unavailableRooms.add(booking.getBooked_room());
        }
        rooms.removeAll(unavailableRooms);
        return rooms;
    }

    public Boolean CancelBooking(Long bookingid) {
        try {
            Optional<Booking> booking = bookingRepository.findById(bookingid);
            bookingRepository.deleteById(bookingid);

            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
}

