package com.csu.dao.train.impl;

import com.csu.dao.train.TrainDao;
import com.csu.domain.train.Train;

import java.util.List;

/**
 * Created by sx on 2016/9/15.
 */
public class TrainDaoImpl implements TrainDao {
    @Override
    public List<Train> getAllTrains() {
        return null;
    }

    @Override
    public Train getTrainBytrainId(int trainId) {
        return null;
    }

    @Override
    public boolean insertTrain(Train train) {
        return false;
    }

    @Override
    public boolean deleteTrainBytrainId(int trainId) {
        return false;
    }

    @Override
    public boolean updateTrain(Train train) {
        return false;
    }
}
