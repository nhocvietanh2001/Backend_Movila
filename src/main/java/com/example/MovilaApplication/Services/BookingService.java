package com.example.MovilaApplication.Services;

import com.example.MovilaApplication.Models.*;
import com.example.MovilaApplication.Pattern.AdapterToList;
import com.example.MovilaApplication.Pattern.FacadeBookingBill;
import com.example.MovilaApplication.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Booking> InsertBooking(Booking booking, Long rid, Long uid) {
        try
        {
            Optional<Booking> foundBooking = bookingRepository.findBookingByRidAndUid(rid, uid);
            if (foundBooking.isPresent()) {
                AdapterToList<Booking> adapter = new AdapterToList(foundBooking.get());

                return adapter.getListT();
            }

            User user = userRepository.findById(uid).get();
            Room room = roomRepository.findById(rid).get();
            LocalDate now = LocalDate.now();
            booking.setCheckinDate(now);
            booking.setUser_booking(user);
            booking.setBooked_room(room);
            bookingRepository.save(booking);
            AdapterToList<Booking> adapter = new AdapterToList(booking);

            return adapter.getListT();
        }
        catch (Exception e){
            return null;
        }
    }

    public List<Bill> DeleteBookingAndInsertBill(Long bookingid) {
        /*Optional<Booking> booking = bookingRepository.findById(bookingid);

        LocalDate checkinDate = booking.get().getCheckinDate();

        Integer day = Math.toIntExact(ChronoUnit.DAYS.between(checkinDate, checkoutDate)) + 1;
        Float price = Float.valueOf(booking.get().getBooked_room().getPrice() * day / 10);

        Bill bill = new Bill(booking.get().getCheckinDate(), checkoutDate, price, booking.get().getUser_booking(), booking.get().getBooked_room());

        billRepository.save(bill);
        bookingRepository.deleteById(bookingid);

        List<Bill> bills = new ArrayList<>();
        bills.add(bill);*/
        FacadeBookingBill facadeBookingBill = new FacadeBookingBill(bookingRepository, billRepository);
        return facadeBookingBill.DeleteBookingAndInsertBill(bookingid);

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
        boolean exists = bookingRepository.existsById(bookingid);
        if(!exists){
            return false;
        }
        else{
            bookingRepository.deleteById(bookingid);
            return true;
        }
    }
}

