package com.csu.service;

import com.csu.dao.diaoDu.DiaoDuDao;
import com.csu.dao.diaoDu.impl.DiaoDuDaoImpl;
import com.csu.domain.diaoDu.Seat;

import java.util.List;

/**
 * Created by 温 睿诚 on 2016/9/16/0016.
 */
public class DiaoduService {
    private DiaoDuDao diaoDuDao;
    public DiaoduService(){
        diaoDuDao=new DiaoDuDaoImpl();
    }
    List<Seat> getSeatsByTrainIdAndCheXiang(int trainId, int chexiang){
        return diaoDuDao.getSeatsByTrainIdAndCheXiang(trainId,chexiang);
    } //按照车次、车厢查询席位
    boolean updateSeat(Seat seat){
        return diaoDuDao.updateSeat(seat);
    }   //修改席位信息
    int getSeatsCountByStatus(int trainId,String status){
        return diaoDuDao.getSeatsCountByStatus(trainId,status);
    }   //根据车次代码和席位售出状态进行客运统计
    int getAllSeatsCount(int trainId){
        return diaoDuDao.getAllSeatsCount(trainId);
    }    //根据车次代码按总席位进行客运统计
}
