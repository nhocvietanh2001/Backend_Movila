package com.example.MovilaApplication.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (name="ufirst_name")
    private String firstName;

    @Column (name="ulast_name")
    private String lastName;

    @Column (name="uphone")
    private String phone;

    @Column (name="umail")
    private String mail;

    private Integer aid;

    // Relational
    // User - Booking
    @JsonIgnore
    @OneToMany(mappedBy = "user_booking")
    List<Booking> bookingList;

    // User - Account
    @OneToOne
    @JoinColumn(
            name = "Account_ID",
            referencedColumnName = "aid"
    )
    private Account account;

    // User - Bill
    @JsonIgnore
    @OneToMany(mappedBy = "user_billing")
    List<Bill> billList;

    //Relational


    public User() {}

    public User(String firstName, String lastName, String phone, String mail, Integer aid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.mail = mail;
        this.aid = aid;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", aid=" + aid +
                '}';
    }
}
