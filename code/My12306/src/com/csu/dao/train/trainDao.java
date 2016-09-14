package com.csu.dao.train;

import com.csu.domain.train.Train;

/**
 * Created by war on 2016/9/14.
 */
public interface TrainDao {
    Train getTrainBytrainId(int trainId);//根据车次查询
    boolean insertTrain(Train train);
    boolean deleteTrainBytrainId(int trainId);
    boolean updateTrain(Train train);
}
