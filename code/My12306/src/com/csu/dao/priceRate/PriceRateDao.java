package com.csu.dao.priceRate;

import com.csu.domain.priceRate.PriceRate;

/**
 * Created by sx on 2016/9/15.
 */
public interface PriceRateDao {
    double getPriceRateByticketType(String ticketType);
    boolean updatePriceRate(PriceRate PriceRate);
}
