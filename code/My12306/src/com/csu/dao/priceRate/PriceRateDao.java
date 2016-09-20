package com.csu.dao.priceRate;

import com.csu.domain.priceRate.PriceRate;

import java.util.ArrayList;

/**
 * Created by sx on 2016/9/15.
 */
public interface PriceRateDao {
    ArrayList<PriceRate> getAllPriceRate();
    PriceRate getPriceRateByticketType(String ticketType);
    boolean updatePriceRate(PriceRate PriceRate);
}
