package com.csu.dao.trainGrouped;

import com.csu.domain.trainGrouped.trainGrouped;

/**
 * Created by war on 2016/9/14.
 */
public interface trainGroupedDao {
    trainGrouped getTrainGroupBytrainId(int trainId);
    void insertTrainGroup(trainGrouped trainGroup);
    void deleteTrainGroupBytrainId(int trainId);
    void updateTrainGroup(trainGrouped trainGroup);
}
