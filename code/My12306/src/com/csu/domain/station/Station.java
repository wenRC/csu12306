package edu.perp.domain;

/**
 * Created by Asus_ on 2016/9/13.
 */
public class Station {
    public Station() {
    }

    public Station(String stationId, String stationName, String pinYin, String location) {
        this.stationId = stationId;
        this.stationName = stationName;
        this.pinYin = pinYin;
        this.location = location;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getPinYin() {
        return pinYin;
    }

    public void setPinYin(String pinYin) {
        this.pinYin = pinYin;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private String stationId;
    private String stationName;
    private String pinYin;
    private String location;

}
