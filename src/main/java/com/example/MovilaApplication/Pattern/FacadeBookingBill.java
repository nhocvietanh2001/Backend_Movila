package com.example.MovilaApplication.Pattern;

import com.example.MovilaApplication.Models.Bill;
import com.example.MovilaApplication.Models.Booking;
import com.example.MovilaApplication.Repositories.BillRepository;
import com.example.MovilaApplication.Repositories.BookingRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacadeBookingBill {

    BookingRepository bookingRepository;

    BillRepository billRepository;

    public FacadeBookingBill(BookingRepository bookingRepository, BillRepository billRepository) {
        this.bookingRepository = bookingRepository;
        this.billRepository = billRepository;
    }

    public List<Bill> DeleteBookingAndInsertBill(Long bookingid) {
        Optional<Booking> booking = bookingRepository.findById(bookingid);
        LocalDate checkoutDate = LocalDate.now();
        float price = Calculate.calculatePrice(booking.get(), checkoutDate);
        Bill bill = new Bill(booking.get().getCheckinDate(), checkoutDate, price, booking.get().getUser_booking(), booking.get().getBooked_room());

        billRepository.save(bill);
        bookingRepository.deleteById(bookingid);

        List<Bill> bills = new ArrayList<>();
        bills.add(bill);

        return bills;
    }
}
