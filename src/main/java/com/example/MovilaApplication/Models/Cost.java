package com.example.MovilaApplication.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name= "cost")
public class Cost {
    @Id
    private Integer hid;
    private Date day;
    private int amount;

    public Cost() {
    }

    public Cost(Integer hid, Date day, int amount) {
        this.hid = hid;
        this.day = day;
        this.amount = amount;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Cost{" +
                "hid=" + hid +
                ", day=" + day +
                ", amount=" + amount +
                '}';
    }
}
