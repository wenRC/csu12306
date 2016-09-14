package com.csu.dao.trainGrouped;

import com.csu.domain.trainGrouped.TrainGrouped;

/**
 * Created by war on 2016/9/14.
 */
public interface TrainGroupedDao {
    TrainGrouped getTrainGroupBytrainIdAndCheXiang(int trainId,int chexiang);
    boolean insertTrainGroup(TrainGrouped trainGroup);
    boolean deleteTrainGroupBytrainIdAndCheXiang(int trainId,int chexiang);
    boolean updateTrainGroup(TrainGrouped trainGroup);
}
