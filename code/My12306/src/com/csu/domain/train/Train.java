package com.csu.domain.train;

import java.sql.Timestamp;


/**
 * Created by sx on 2016/9/15.
 */
public class Train {
    private int trainId;
    private String from;
    private String to;
    private Timestamp fromTime;
    private Timestamp toTime;
    private String last;
    private int distance;
    private int noseatnumber;
    private String type;
    public Train(){}
    public Train(int trainId, String from, String to, Timestamp fromTime, Timestamp toTime, String last, int distance, int noseatnumber, String type) {
        this.trainId = trainId;
        this.from = from;
        this.to = to;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.last = last;
        this.distance = distance;
        this.noseatnumber = noseatnumber;
        this.type = type;
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

    public Timestamp getFromTime() {
        return fromTime;
    }

    public void setFromTime(Timestamp fromTime) {
        this.fromTime = fromTime;
    }

    public Timestamp getToTime() {
        return toTime;
    }

    public void setToTime(Timestamp toTime) {
        this.toTime = toTime;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getNoseatnumber() {
        return noseatnumber;
    }

    public void setNoseatnumber(int noseatnumber) {
        this.noseatnumber = noseatnumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
