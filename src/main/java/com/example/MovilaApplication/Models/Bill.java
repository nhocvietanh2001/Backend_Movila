package com.example.MovilaApplication.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="billdb")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "billid")
    private Long id;
    private Date checkinDate;
    private Date checkoutDate;
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

    public Bill(Date checkinDate, Date checkoutDate, Integer price) {
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public User getUser_billing() {
        return user_billing;
    }

    public void setUser_billing(User user) {
        this.user_billing = user;
    }

    //
//    public Room getRoom() {
//        return room;
//    }
//
//    public void setRoom(Room room) {
//        this.room = room;
//    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", checkinDate=" + checkinDate +
                ", checkoutDate=" + checkoutDate +
                ", price=" + price +
                ", user_billing=" + user_billing +
                '}';
    }
}
