package com.csu.domain.plan;

/**
 * Created by sx on 2016/9/14.
 */
public class Plan {
    private int planid;     //计划代码
    private int trainid;    //车次代码
    private int chexiang;   //车厢号
    private String compare; //比较
    private String stationname; //车站

    public int getPlanid() {
        return planid;
    }

    public void setPlanid(int planid) {
        this.planid = planid;
    }

    public int getTrainid() {
        return trainid;
    }

    public void setTrainid(int trainid) {
        this.trainid = trainid;
    }

    public int getChexiang() {
        return chexiang;
    }

    public void setChexiang(int chexiang) {
        this.chexiang = chexiang;
    }

    public String getCompare() {
        return compare;
    }

    public void setCompare(String compare) {
        this.compare = compare;
    }

    public String getStationname() {
        return stationname;
    }

    public void setStationname(String stationname) {
        this.stationname = stationname;
    }
}
