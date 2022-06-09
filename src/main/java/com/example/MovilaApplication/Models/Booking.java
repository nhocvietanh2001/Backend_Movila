package com.example.MovilaApplication.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name= "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate checkinDate;
    // Relational

    // Book-User
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "uid",
            referencedColumnName = "uid" // id of the user
    )
    private User user_booking;

    // Book-Room
    @OneToOne()
    @JoinColumn(
            name = "rid",
            referencedColumnName = "rid"
    )
    private Room booked_room;

    // Relational

    // Constructors
    public Booking() {
    }

    public Booking(LocalDate checkinDate) {
        this.checkinDate = checkinDate;
    }

    public LocalDate getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(LocalDate checkinDate) {
        this.checkinDate = checkinDate;
    }

    public User getUser_booking() {
        return user_booking;
    }

    public void setUser_booking(User user) {
        this.user_booking = user;
    }

    public Room getBooked_room() {
        return booked_room;
    }

    public void setBooked_room(Room booked_room) {
        this.booked_room = booked_room;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", checkinDate=" + checkinDate +
                ", user_booking=" + user_booking +
                ", booked_room=" + booked_room +
                '}';
    }
}
