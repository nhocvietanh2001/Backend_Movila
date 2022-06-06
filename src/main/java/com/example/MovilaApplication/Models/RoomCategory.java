package com.example.MovilaApplication.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roomcat")
public class RoomCategory {
    @Id
    private Integer id;
    private String cname;

    public RoomCategory() {
    }

    public RoomCategory(Integer id, String cname) {
        this.id = id;
        this.cname = cname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer cid) {
        this.id = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "RoomCategory{" +
                "cid=" + id +
                ", cname='" + cname + '\'' +
                '}';
    }
}
