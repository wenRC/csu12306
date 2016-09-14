package com.csu.dao.train;

import com.csu.domain.train.train;

/**
 * Created by war on 2016/9/14.
 */
public interface trainDao {
    train getTrainBytrainId(int trainId);//根据车次查询
    void insertTrain(train train);
    void deleteTrainBytrainId(int trainId);
    void updateTrain(train train);
}
