package com.csu.domain.piaoWu;

import java.sql.Timestamp;

/**
 * Created by 温 睿诚 on 2016/9/16/0016.
 */
public class Ticket {
    private int ticketId;
    private int seatId;
    private double price;
    private String saleMode;
    private String ticketType;
    private int userId;
    private String userType;
    private Timestamp salesTime;
    private String ticketStatus;

    public Timestamp getSalesTime() {
        return salesTime;
    }

    public void setSalesTime(Timestamp salesTime) {
        this.salesTime = salesTime;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Ticket() {
    }

    public Ticket(int ticketId, int seatId, double price, String saleMode, String ticketType, int userId, String userType) {
        this.ticketId = ticketId;
        this.seatId = seatId;
        this.price = price;
        this.saleMode = saleMode;
        this.ticketType = ticketType;
        this.userId = userId;
        this.userType = userType;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSaleMode() {
        return saleMode;
    }

    public void setSaleMode(String saleMode) {
        this.saleMode = saleMode;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
