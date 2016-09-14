package com.csu.service;

import com.csu.dao.priceRate.PriceRateDao;
import com.csu.dao.priceRate.impl.PriceRateDaoImpl;
import com.csu.dao.train.TrainDao;
import com.csu.dao.train.impl.TrainDaoImpl;
import com.csu.dao.trainGrouped.TrainGroupedDao;
import com.csu.dao.trainGrouped.impl.TrainGroupedDaoImpl;

/**
 * Created by 温 睿诚 on 2016/9/14/0014.
 */
public class BaseService {
    private PriceRateDao priceRateDao;
    private TrainDao trainDao;
    private TrainGroupedDao trainGroupedDao;
    public BaseService(){
        priceRateDao = new PriceRateDaoImpl();
        trainDao = new TrainDaoImpl();
        trainGroupedDao = new TrainGroupedDaoImpl();
    }
    
}
