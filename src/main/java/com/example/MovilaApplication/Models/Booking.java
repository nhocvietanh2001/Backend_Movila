package com.example.MovilaApplication.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer uid;
    private Integer rid;

    // Relational

    // Book-Bill
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "Bill_ID",
            referencedColumnName = "id"
    )
    private Bill booked_bill;

    // Book-User
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "User_ID",
            referencedColumnName = "id" // id of the user
    )
    private User user;

    // Book-Room
    @OneToOne()
    @JoinColumn(
            name = "booked_room",
            referencedColumnName = "rid"
    )
    private Room booked_room;

    // Relational

    // Constructors
    public Booking() {
    }

    public Booking(Integer id, Integer uid, Integer rid) {
        this.id = id;
        this.uid = uid;
        this.rid = rid;
    }


    public Bill getBooked_bill() {
        return booked_bill;
    }

    public void setBooked_bill(Bill booked_bill) {
        this.booked_bill = booked_bill;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getBooked_room() {
        return booked_room;
    }

    public void setBooked_room(Room booked_room) {
        this.booked_room = booked_room;
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

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", uid=" + uid +
                ", rid=" + rid +
                '}';
    }
}
