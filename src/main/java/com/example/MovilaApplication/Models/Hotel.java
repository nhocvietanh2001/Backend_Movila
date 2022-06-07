package com.example.MovilaApplication.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name= "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="hid")
    private Long id;

    @Column(name="hname")
    private String name;

    private Integer aid;

    private String address;

    private String phone;

    @OneToMany(mappedBy = "hotel")
    @JsonIgnore
    private List<Room> rooms;

    public Hotel() {
    }

    public Hotel(String name, Integer aid, String address, String phone) {
        this.name = name;
        this.aid = aid;
        this.address = address;
        this.phone = phone;
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

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", aid=" + aid +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}
