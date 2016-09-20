package com.csu.dao.trainGrouped;

import com.csu.domain.trainGrouped.TrainGrouped;

import java.util.ArrayList;

/**
 * Created by sx on 2016/9/18.
 */
public interface TrainGroupedDao {
    ArrayList<TrainGrouped> getAllTrainGroups();
    TrainGrouped getTrainGroupBytrainGroupedId(int trainGroupedId);
    ArrayList<TrainGrouped> getTrainGroupBytrainId(int trainId);
    TrainGrouped getTrainGroupBytrainIdAndCheXiang(int trainId, int chexiang);
    boolean insertTrainGroup(TrainGrouped trainGroup);
    boolean deleteTrainGroupBytrainIdAndCheXiang(int trainId,int chexiang);
    boolean updateTrainGroup(TrainGrouped trainGroup);
}
