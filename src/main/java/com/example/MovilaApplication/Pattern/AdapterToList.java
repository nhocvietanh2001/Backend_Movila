package com.example.MovilaApplication.Pattern;

import com.example.MovilaApplication.Models.*;

import java.util.ArrayList;
import java.util.List;

public class AdapterToList<T> {

    private T t;

    public AdapterToList(T t) {
        this.t = t;
    }

    public List<T> getListT() {
        List<T> ts = new ArrayList<>();
        ts.add(this.t);
        return ts;
    }

/*    Account account;
    Bill bill;
    Room room;
    User user;
    Hotel hotel;
    Booking booking;
    Contact contact;

    public AdapterToList(Account account) {
        this.account = account;
    }

    public AdapterToList(Bill bill) {
        this.bill = bill;
    }

    public AdapterToList(Room room) {
        this.room = room;
    }

    public AdapterToList(User user) {
        this.user = user;
    }

    public AdapterToList(Hotel hotel) {
        this.hotel = hotel;
    }

    public AdapterToList(Booking booking) {
        this.booking = booking;
    }

    public AdapterToList(Contact contact) {
        this.contact = contact;
    }

    public List<Account> getListAccount() {
        List<Account> accounts = new ArrayList<>();
        accounts.add(this.account);
        return accounts;
    }

    public List<Bill> getListBill() {
        List<Bill> bills = new ArrayList<>();
        bills.add(this.bill);
        return bills;
    }

    public List<Room> getListRoom() {
        List<Room> rooms = new ArrayList<>();
        rooms.add(this.room);
        return rooms;
    }

    public List<User> getListUser() {
        List<User> users = new ArrayList<>();
        users.add(this.user);
        return users;
    }

    public List<Hotel> getListHotel() {
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(this.hotel);
        return hotels;
    }

    public List<Booking> getListBooking() {
        List<Booking> bookings = new ArrayList<>();
        bookings.add(this.booking);
        return bookings;
    }

    public List<Contact> getListContact() {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(this.contact);
        return contacts;
    }*/

/*    Object object;

    public AdapterToList(Object object) {
        this.object = object;
    }

    public List<Object> getListObject() {
        List<Object> objects = new ArrayList<>();
        objects.add(this.object);
        return objects;
    }*/

}
