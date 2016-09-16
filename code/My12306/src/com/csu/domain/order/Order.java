package com.csu.domain.order;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by 温 睿诚 on 2016/9/16/0016.
 */
public class Order {
    private int orderId;
    private int passengerId;
    private String orderStatus;
    private Timestamp orderTime;

    public Order() {
    }

    public Order(int orderId, int passengerId, String orderStatus, Timestamp orderTime) {
        this.orderId = orderId;
        this.passengerId = passengerId;
        this.orderStatus = orderStatus;
        this.orderTime = orderTime;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }
}
