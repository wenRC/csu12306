package com.csu.domain.quDuan;

/**
 * Created by sx on 2016/9/12.
 */
public class QuDuan {
    private int quDuanId;   //旅程区段编号
    private String from;    //里程区段From
    private String to;      //里程区段To
    private int distancePerQD;//每区段里程
    private int qdNumber;   //区段数

    public QuDuan() {
    }

    public QuDuan(int quDuanId, String from, String to, int distancePerQD, int qdNumber) {
        this.quDuanId = quDuanId;
        this.from = from;
        this.to = to;
        this.distancePerQD = distancePerQD;
        this.qdNumber = qdNumber;
    }

    public int getQuDuanId() {
        return quDuanId;
    }

    public void setQuDuanId(int quDuanId) {
        this.quDuanId = quDuanId;
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

    public int getDistancePerQD() {
        return distancePerQD;
    }

    public void setDistancePerQD(int distancePerQD) {
        this.distancePerQD = distancePerQD;
    }

    public int getQdNumber() {
        return qdNumber;
    }

    public void setQdNumber(int qdNumber) {
        this.qdNumber = qdNumber;
    }
}
