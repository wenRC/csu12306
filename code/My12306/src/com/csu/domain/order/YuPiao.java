package com.csu.domain.order;

import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 温 睿诚 on 2016/9/18/0018.
 */
public class YuPiao {
    int trainId;
    String from;//从那里出发
    String to;//到哪里
    Date date;//日期
    Time time;//详细时间
    String last;//历时
    Map<Integer,String> cheXiang2SeatType;
    int seatNo;
    double price;
    int seatId;//获取未售席位

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public YuPiao() {
        cheXiang2SeatType=new HashMap<>();
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public Map<Integer, String> getCheXiang2SeatType() {
        return cheXiang2SeatType;
    }

    public void setCheXiang2SeatType(Map<Integer, String> cheXiang2SeatType) {
        this.cheXiang2SeatType = cheXiang2SeatType;
    }

}
