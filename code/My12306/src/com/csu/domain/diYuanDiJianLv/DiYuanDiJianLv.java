package edu.perp.domain;

/**
 * Created by Asus_ on 2016/9/13.
 */
public class DiYuanDiJianLv {
    public DiYuanDiJianLv(){

    }

    public String getDYDJId() {
        return dYDJId;
    }

    public void setDYDJId(String dYDJId) {
        this.dYDJId = dYDJId;
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

    public double getDYDJRate() {
        return dYDJRate;
    }

    public void setDYDJRate(double dYDJRate) {
        this.dYDJRate = dYDJRate;
    }

    public double getPriceRate() {
        return priceRate;
    }

    public void setPriceRate(double priceRate) {
        this.priceRate = priceRate;
    }


    public DiYuanDiJianLv(String dYDJId, String from, String to, double dYDJRate, double priceRate) {
        this.dYDJId = dYDJId;
        this.from = from;
        this.to = to;
        this.dYDJRate = dYDJRate;
        this.priceRate = priceRate;
    }

    private String dYDJId;
    private String from;
    private String to;
    private double dYDJRate;
    private double priceRate;

}
