package com.csu.domain.line;

/**
 * Created by Asus_ on 2016/9/13.
 */
public class Line {
    private int lineId;//线路编号
    private int trainId;//车次
    private String stationName;//车站名
    private int distance;//里程
    private String fromTime;//到站时间
    private String lastTime;//停留时间

    public Line() {
    }

    public Line(int lineId, int trainId, String stationName, int distance,String fromTime, String lastTime) {
        this.lineId = lineId;
        this.trainId = trainId;
        this.stationName = stationName;
        this.distance = distance;
        this.fromTime = fromTime;
        this.lastTime = lastTime;
    }

    public int getLineId() {
        return lineId;
    }

    public void setLineId(int lineId) {
        this.lineId = lineId;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }
}
