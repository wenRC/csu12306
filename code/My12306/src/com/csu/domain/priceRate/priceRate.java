package com.csu.domain.priceRate;

/**
 * Created by war on 2016/9/14.
 */
public class priceRate {
        private int priceRateId;
        private String ticketType;
        private int priceRate;

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

        public int getPriceRate() {
            return priceRate;
        }

        public void setPriceRate(int priceRate) {
            this.priceRate = priceRate;
        }
}
