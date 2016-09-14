package edu.perp.domain;

import sun.util.calendar.BaseCalendar;

/**
 * Created by Asus_ on 2016/9/13.
 */
public class Line {
    public Line() {
    }

    public Line(String lineId, String trainId, String stationName, int distance, BaseCalendar.Date fromTime, String lastTime) {
        this.lineId = lineId;
        this.trainId = trainId;
        this.stationName = stationName;
        this.distance = distance;
        this.fromTime = fromTime;
        this.lastTime = lastTime;
    }

    private String lineId;

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public BaseCalendar.Date getFromTime() {
        return fromTime;
    }

    public void setFromTime(BaseCalendar.Date fromTime) {
        this.fromTime = fromTime;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    private String trainId;
    private String stationName;
    private int distance;
    private BaseCalendar.Date fromTime;
    private String lastTime;
}
