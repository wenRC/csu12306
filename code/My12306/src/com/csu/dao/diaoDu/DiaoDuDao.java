package com.csu.dao.diaoDu;

import com.csu.domain.diaoDu.Seat;

import java.util.List;

/**
 * Created by sx on 2016/9/14.
 */
public interface DiaoDuDao {
    List<Seat> getSeatsByTrainId(int trainId);  //按照车次代码查询席位
    List<Seat> getSeatsByCheXiang(int chexiang);    //按照车厢号查询席位
    boolean updateSeat(Seat seat);    //修改席位信息
    int getSeatsCountByStatus(String status);    //按席位售出状态进行客运统计
    int getAllSeatsCount();    //按总席位进行客运统计
}
