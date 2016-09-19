package com.csu.dao.diaoDu;

import com.csu.domain.diaoDu.Seat;

import java.util.List;

/**
 * Created by sx on 2016/9/14.
 */
public interface DiaoDuDao {
    Seat getSeatBySeatId(int seatid);   //按照席位代码进行查询
    List<Seat> getSeatsByTrainIdAndCheXiang(int trainId,int chexiang);  //按照车次、车厢查询席位
    List<Seat> getSeatsByTrainId(int trainId);
    List<Seat> getAllSeats();   //查询出所有的席位

    boolean updateSeat(Seat seat);    //修改席位信息
    List<Seat> getSeatsByStatus(String status);//根据席位售出状态进行查询席位
    int getSeatsCountByStatus(String status);    //根据席位售出状态进行客运统计
    int getAllSeatsCount();    //按总席位进行客运统计

}
