package com.example.MovilaApplication.Models;

import javax.persistence.*;

public abstract class AAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="aid")
    private Long id;
    private String username;
    private String role;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="uid")
    private User user;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="hid")
    private Hotel hotelaccount;

    public AAccount() {
    }

    public AAccount(String username,  String role) {
        this.username = username;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Hotel getHotelaccount() {
        return hotelaccount;
    }

    public void setHotelaccount(Hotel hotelaccount) {
        this.hotelaccount = hotelaccount;
    }
}
