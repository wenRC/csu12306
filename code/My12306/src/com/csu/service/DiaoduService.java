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

    /**
     * 按照席位代码进行查询
     * @param seatid
     * @return
     */
    public Seat getSeatBySeatId(int seatid){
        return diaoDuDao.getSeatBySeatId(seatid);
    }

    /**
     * 按照车次、车厢查询席位
     * @param trainId
     * @param chexiang
     * @return
     */
    public List<Seat> getSeatsByTrainIdAndCheXiang(int trainId, int chexiang){
        return diaoDuDao.getSeatsByTrainIdAndCheXiang(trainId,chexiang);
    }

    /**
     * 按照车次查询席位
     * @param trainId
     * @return
     */
    public List<Seat> getSeatsByTrainId(int trainId){
        return diaoDuDao.getSeatsByTrainId(trainId);
    }

    /**
     * 查询出所有的席位
     * @return
     */
    public List<Seat> getAllSeats(){
        return diaoDuDao.getAllSeats();
    }

    /**
     * 修改席位信息
     * @param seat
     * @return
     */
    public boolean updateSeat(Seat seat){
        return diaoDuDao.updateSeat(seat);
    }

    /**
     * 根据车次代码和席位售出状态进行客运统计
     * @param trainId
     * @param status
     * @return
     */
    public int getSeatsCountByStatus(int trainId,String status){
        return diaoDuDao.getSeatsCountByStatus(trainId,status);
    }

    /**
     * 根据车次代码按总席位进行客运统计
     * @param trainId
     * @return
     */
    public int getAllSeatsCount(int trainId){
        return diaoDuDao.getAllSeatsCount(trainId);
    }
    public Seat getSeatBySeatId(int seatId){
        return diaoDuDao.getSeatBySeatId(seatId);
    }

}
