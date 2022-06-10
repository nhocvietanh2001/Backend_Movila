package com.example.MovilaApplication.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="billdb")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "billid")
    private Long id;
    private LocalDate checkinDate;
    private LocalDate checkoutDate;
    private Integer price;

//    // Relational
//    // Bill - Booking
//    @OneToOne(mappedBy = "booked_bill")
//    private Booking booking;

    // Bill - User
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "uid",
            referencedColumnName = "uid"
    )
    private User user_billing;

    // Bill - Room
    @OneToOne
    @JoinColumn(
            name = "rid",
            referencedColumnName = "rid"
    )
    private Room room_billing;

    // Relational


    public Bill() {
    }

    public Bill(LocalDate checkinDate, LocalDate checkoutDate, Integer price, User user_billing, Room room_billing) {
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.price = price;
        this.user_billing = user_billing;
        this.room_billing = room_billing;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(LocalDate checkinDate) {
        this.checkinDate = checkinDate;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public User getUser_billing() {
        return user_billing;
    }

    public void setUser_billing(User user) {
        this.user_billing = user;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Room getRoom_billing() {
        return room_billing;
    }

    public void setRoom_billing(Room room_billing) {
        this.room_billing = room_billing;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", checkinDate=" + checkinDate +
                ", checkoutDate=" + checkoutDate +
                ", user_billing=" + user_billing +
                ", room_billing=" + room_billing +
                '}';
    }
}
