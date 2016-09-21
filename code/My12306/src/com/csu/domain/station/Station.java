package com.csu.domain.station;

/**
 * Created by Asus_ on 2016/9/13.
 */
public class Station {

    private int stationId;//车站编号
    private String stationName;//车站名
    private String pinYin;//拼音码
    private String location;//所在地
    private String ju;//铁路局
    private int level;
    private String phone;//联系电话

    public Station() {
    }

    public Station(int stationId, String stationName, String pinYin, String location) {
        this.stationId = stationId;
        this.stationName = stationName;
        this.pinYin = pinYin;
        this.location = location;
    }

    public Station(int stationId, String stationName, String pinYin, String location, String ju, int level, String phone) {
        this.stationId = stationId;
        this.stationName = stationName;
        this.pinYin = pinYin;
        this.location = location;
        this.ju = ju;
        this.level = level;
        this.phone = phone;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
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

    public String getJu() {
        return ju;
    }

    public void setJu(String ju) {
        this.ju = ju;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
