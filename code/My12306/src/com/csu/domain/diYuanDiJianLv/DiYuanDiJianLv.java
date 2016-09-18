package com.csu.domain.diYuanDiJianLv;

/**
 * Created by Asus_ on 2016/9/13.
 */
public class DiYuanDiJianLv {
    private String dYDJId;//地缘递减率编号
    private String dYDJFrom;//区段FROM
    private String dYDJTo;//区段TO
    private double dYDJRate;//地缘递减率
    private double priceRate;//票价率

    public DiYuanDiJianLv() {
    }

    public DiYuanDiJianLv(String dYDJId, String dYDJFrom, String dYDJTo, double dYDJRate, double priceRate) {
        this.dYDJId = dYDJId;
        this.dYDJFrom = dYDJFrom;
        this.dYDJTo = dYDJTo;
        this.dYDJRate = dYDJRate;
        this.priceRate = priceRate;
    }

    public String getdYDJId() {
        return dYDJId;
    }

    public void setdYDJId(String dYDJId) {
        this.dYDJId = dYDJId;
    }

    public String getdYDJFrom() {
        return dYDJFrom;
    }

    public void setdYDJFrom(String dYDJFrom) {
        this.dYDJFrom = dYDJFrom;
    }

    public String getdYDJTo() {
        return dYDJTo;
    }

    public void setdYDJTo(String dYDJTo) {
        this.dYDJTo = dYDJTo;
    }

    public double getdYDJRate() {
        return dYDJRate;
    }

    public void setdYDJRate(double dYDJRate) {
        this.dYDJRate = dYDJRate;
    }

    public double getPriceRate() {
        return priceRate;
    }

    public void setPriceRate(double priceRate) {
        this.priceRate = priceRate;
    }
}
