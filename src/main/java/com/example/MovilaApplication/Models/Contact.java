package com.example.MovilaApplication.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact")
    private Long id;
    private String name;
    private String surName;
    private String phone;
    private String email;
    private String subject;
    private String message;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(
//            name = "uid",
//            referencedColumnName = "uid"
//    )
//    private User user_contact;
////    // Relational
////    // Bill - Booking
////    @OneToOne(mappedBy = "booked_bill")
////    private Booking booking;
//
//    // Bill - User
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(
//            name = "uid",
//            referencedColumnName = "uid"
//    )
//    private User user_billing;
//
//    // Bill - Room
//    @OneToOne
//    @JoinColumn(
//            name = "rid",
//            referencedColumnName = "rid"
//    )
//    private Room room_billing;

    // Relational


    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public Contact() {
    }

    public Contact(String name, String surName, String phone, String email, String subject, String message) {
        this.name = name;
        this.surName = surName;
        this.phone = phone;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    public Contact(Long id, String name, String surName, String phone, String email, String subject, String message) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.phone = phone;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
