package com.example.MovilaApplication.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="userdb")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private Long id;

    @Column (name="ufirst_name")
    private String firstName;

    @Column (name="ulast_name")
    private String lastName;

    @Column (name="uphone")
    private String phone;

    @Column (name="umail")
    private String mail;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    @JsonIgnore
    private Account account;

    // Relational
    // User - Booking
    @JsonIgnore
    @OneToMany(
            mappedBy = "user_booking",
            fetch = FetchType.EAGER
    )
    Set<Booking> bookingList = new HashSet<>();

    // User - Bill
    @JsonIgnore
    @OneToMany(mappedBy = "user_billing", fetch = FetchType.EAGER)
    Set<Bill> billList = new HashSet<>();

    //Relational


    public User() {}

    public User(String firstName, String lastName, String phone, String mail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.mail = mail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", account=" + account +
                '}';
    }

    public Set<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(Set<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public Set<Bill> getBillList() {
        return billList;
    }

    public void setBillList(Set<Bill> billList) {
        this.billList = billList;
    }
}
