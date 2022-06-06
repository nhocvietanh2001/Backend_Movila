package com.example.MovilaApplication.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer rid;
    private Integer hid;
    private Date checkinDate;
    private Date checkoutDate;
    private Integer price;


//    // Relational
//    // Bill - Booking
//    @OneToOne(mappedBy = "booked_bill")
//    private Booking billed_booking;

    // Bill - User
    @JsonIgnore
    @ManyToOne
    @JoinColumn(
            name = "user_billing",
            referencedColumnName = "id"
    )
    private User user_billing;

//    // Bill - Room
//    @OneToOne
//    @JoinColumn(
//            name = "Bill-Room",
//            referencedColumnName = "rid"
//    )
//    private Room room;

    // Relational


    public Bill() {
    }

    public Bill(Integer id, Integer rid, Integer hid, Date checkinDate, Date checkoutDate, Integer price) {
        this.id = id;
        this.rid = rid;
        this.hid = hid;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.price = price;
    }

    public Bill(Integer price) {
        this.price = price;
    }
//    public Booking getBilled_booking() {
//        return billed_booking;
//    }
//
//    public void setBilled_booking(Booking billed_booking) {
//        this.billed_booking = billed_booking;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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
                ", rid=" + rid +
                ", hid=" + hid +
                ", checkinDate=" + checkinDate +
                ", checkoutDate=" + checkoutDate +
                ", price=" + price +
                '}';
    }
}
