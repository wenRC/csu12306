package com.csu.dao.priceRate;

import com.csu.domain.priceRate.priceRate;

/**
 * Created by war on 2016/9/14.
 */
public interface priceRateDao {
    int getPriceRateByticketType();
    void updatePriceRate(priceRate priceRate);
}
