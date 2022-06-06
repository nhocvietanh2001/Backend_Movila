package com.example.MovilaApplication.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer uid;
    private Integer rid;
    private Integer hid;
    private Date checkinDate;
    private Date checkoutDate;
    private Integer price;


    // Relational
    @OneToOne(mappedBy = "booked_bill")
    private Booking billed_booking = new Booking();

    public Bill() {
    }

    public Bill(Integer id, Integer uid, Integer rid, Integer hid, Date checkinDate, Date checkoutDate, Integer price) {
        this.id = id;
        this.uid = uid;
        this.rid = rid;
        this.hid = hid;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.price = price;
    }

    public Booking getBilled_booking() {
        return billed_booking;
    }

    public void setBilled_booking(Booking billed_booking) {
        this.billed_booking = billed_booking;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", uid=" + uid +
                ", rid=" + rid +
                ", hid=" + hid +
                ", checkinDate=" + checkinDate +
                ", checkoutDate=" + checkoutDate +
                ", price=" + price +
                '}';
    }
}
