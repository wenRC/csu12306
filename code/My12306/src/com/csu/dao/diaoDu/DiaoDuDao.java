package com.csu.dao.diaoDu;

import com.csu.domain.diaoDu.Seat;

import java.util.List;

/**
 * Created by sx on 2016/9/14.
 */
public interface DiaoDuDao {
    List<Seat> getSeatsByTrainIdAndCheXiang(int trainId,int chexiang);  //按照车次、车厢查询席位
    boolean updateSeat(Seat seat);    //修改席位信息
    int getSeatsCountByStatus(int trainId,String status);    //根据车次代码和席位售出状态进行客运统计
    int getAllSeatsCount(int trainId);    //根据车次代码按总席位进行客运统计
    Seat getSeatBySeatId(int seatId);
}
