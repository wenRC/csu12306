package com.csu.domain.piaoWu;

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
    private int userType;

    public Ticket() {
    }

    public Ticket(int ticketId, int seatId, double price, String saleMode, String ticketType, int userId, int userType) {
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

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
