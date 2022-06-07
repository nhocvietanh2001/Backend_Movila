package com.example.MovilaApplication.Models;


import javax.persistence.*;

@Entity
@Table(name="room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="rid")
    private Long id;

    @Column(name="rname")
    private String name;

    private String cat;

    private Integer price;

    private Integer numberOfGuest;

    private Integer floor;

    private Integer area;

    private Boolean wifi;

    private String view;

    private String description;

    private String imageURL;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hid", referencedColumnName = "hid")
    private Hotel hotel;

    public Room() {
    }

    public Room(String name, String cat, Integer price, Integer numberOfGuest, Integer floor, Integer area, Boolean wifi, String view, String description, String imageURL) {
        this.name = name;
        //this.roomCategory = roomCategory;
        this.price = price;
        this.numberOfGuest = numberOfGuest;
        this.floor = floor;
        this.area = area;
        this.wifi = wifi;
        this.view = view;
        this.description = description;
        this.imageURL = imageURL;
    }

    public Room(String view) {
        this.view=view;
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

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumberOfGuest() {
        return numberOfGuest;
    }

    public void setNumberOfGuest(Integer numberOfGuest) {
        this.numberOfGuest = numberOfGuest;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cat='" + cat + '\'' +
                ", price=" + price +
                ", numberOfGuest=" + numberOfGuest +
                ", floor=" + floor +
                ", area=" + area +
                ", wifi=" + wifi +
                ", view='" + view + '\'' +
                ", description='" + description + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", hotel=" + hotel +
                '}';
    }
}
