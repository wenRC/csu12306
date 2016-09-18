package com.csu.domain.priceRate;

/**
 * Created by sx on 2016/9/15.
 */
public class PriceRate {
    private int priceRateId;
    private String ticketType;
    private double priceRate;

    public PriceRate(){}
    public PriceRate(int priceRateId, String ticketType, double priceRate) {
        this.priceRateId = priceRateId;
        this.ticketType = ticketType;
        this.priceRate = priceRate;
    }

    public int getPriceRateId() {
        return priceRateId;
    }

    public void setPriceRateId(int priceRateId) {
        this.priceRateId = priceRateId;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public double getPriceRate() {
        return priceRate;
    }

    public void setPriceRate(double priceRate) {
        this.priceRate = priceRate;
    }
}
