package com.csu.dao.train;

import com.csu.domain.train.Train;

import java.util.List;

/**
 * Created by sx on 2016/9/15.
 */
public interface TrainDao {
    List<Train> getAllTrains();
    Train getTrainBytrainId(int trainId);//根据车次查询
    boolean insertTrain(Train train);
    boolean deleteTrainBytrainId(int trainId);
    boolean updateTrain(Train train);}
