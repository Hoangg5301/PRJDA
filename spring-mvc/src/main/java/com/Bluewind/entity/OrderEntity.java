package com.Bluewind.entity;

import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="order")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idorder")
    private Integer orderID;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "createTime")
    private String createTime;

    @NonNull
    @Column(name = "status")
    private String status;

    @NonNull
    @Column(name = "address")
    private String address;

    @NonNull
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name ="Discount")
    private Integer discount;

    @Column(name = "IDTK")
    private Integer accountID;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }
}
