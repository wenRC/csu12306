package com.csu.service;

import com.csu.dao.priceRate.PriceRateDao;
import com.csu.dao.priceRate.impl.PriceRateDaoImpl;
import com.csu.dao.train.TrainDao;
import com.csu.dao.train.impl.TrainDaoImpl;
import com.csu.dao.trainGrouped.TrainGroupedDao;
import com.csu.dao.trainGrouped.impl.TrainGroupedDaoImpl;
import com.csu.domain.priceRate.PriceRate;
import com.csu.domain.train.Train;
import com.csu.domain.trainGrouped.TrainGrouped;

/**
 * Created by 温 睿诚 on 2016/9/14/0014.
 *车站管理
 * 列车管理
 * 线路管理
 * 列车编组管理
 * 票价率管理
 * 票价绿城区段管理
 * 递远递减率管理
 * 的service都在这
 *
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
    double getPriceRateByticketType(String ticketType){
        return priceRateDao.getPriceRateByticketType(ticketType);
    }
    boolean updatePriceRate(PriceRate priceRate){
        return  priceRateDao.updatePriceRate(priceRate);
    }
    Train getTrainBytrainId(int trainId){
        return trainDao.getTrainBytrainId(trainId);
    }
    boolean insertTrain(Train train){
        return trainDao.insertTrain(train);
    }
    boolean deleteTrainBytrainId(int trainId){
        return trainDao.deleteTrainBytrainId(trainId);
    }
    boolean updateTrain(Train train){
        return trainDao.updateTrain(train);
    }
    TrainGrouped getTrainGroupBytrainIdAndCheXiang(int trainId, int chexiang){
        return trainGroupedDao.getTrainGroupBytrainIdAndCheXiang(trainId,chexiang);
    }
    boolean insertTrainGroup(TrainGrouped trainGroup){
        return trainGroupedDao.insertTrainGroup(trainGroup);
    }
    boolean deleteTrainGroupBytrainIdAndCheXiang(int trainId,int chexiang){
        return trainGroupedDao.deleteTrainGroupBytrainIdAndCheXiang(trainId,chexiang);
    }
    boolean updateTrainGroup(TrainGrouped trainGroup){
        return trainGroupedDao.updateTrainGroup(trainGroup);
    }


}
