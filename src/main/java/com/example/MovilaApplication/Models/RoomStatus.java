package com.example.MovilaApplication.Models;

import javax.persistence.*;

@Entity
@Table(name = "room_status")
public class RoomStatus {


    @Id
    @GeneratedValue
    @Column(name = "status_id")
    private Integer id;

    Long hid;
    Long rid;

    // Book ID
    Long bid;
    String status;

    public RoomStatus() {

    }

    @Override
    public String toString() {
        return "RoomStatus{" +
                "id=" + id +
                ", hid=" + hid +
                ", rid=" + rid +
                ", bid=" + bid +
                ", status='" + status + '\'' +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getHid() {
        return hid;
    }

    public void setHid(Long hid) {
        this.hid = hid;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
