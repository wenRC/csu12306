package com.csu.dao.priceRate;

import com.csu.domain.priceRate.PriceRate;

/**
 * Created by war on 2016/9/14.
 */
public interface PriceRateDao {
    double getPriceRateByticketType(String ticketType);
    boolean updatePriceRate(PriceRate PriceRate);
}
