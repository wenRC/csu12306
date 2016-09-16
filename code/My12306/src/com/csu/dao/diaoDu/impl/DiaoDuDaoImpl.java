package com.csu.dao.diaoDu.impl;

import com.csu.dao.diaoDu.DiaoDuDao;
import com.csu.domain.diaoDu.Seat;
import com.csu.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sx on 2016/9/14.
 */
public class DiaoDuDaoImpl implements DiaoDuDao {
    private static final String GETSEATSBYTRAINIDANDCHEXIANG = "select * from seat where trainid = ? and chexiang = ?";
    private static final String UPDATESEAT = "update seat set " +
            "trainid = ?," +    //车次
            "date = ?," +       //日期
            "chexiang = ?," +   //车厢号
            "seatno = ?," +     //座位号
            "from = ?," +       //乘车区间起始站
            "to=?," +           //乘车区间终到站
            "status=? " +       //售票状态
            "where seatid = ?"; //席位代码
    private static final String GETSEATSCOUNTBYSTATUS = "select count(*) from seat where trainid = ? and status = ?";
    private static final String GETALLSEATSCOUNT = "select count(*) from seat where trainid = ?";

    /**
     * 按照车次、车厢查询席位信息
     * @param trainId   车次
     * @param chexiang  车厢号
     * @return  席位信息集合
     */
    @Override
    public List<Seat> getSeatsByTrainIdAndCheXiang(int trainId, int chexiang) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Seat> seatList = new ArrayList<>();
        Seat seat = null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(GETSEATSBYTRAINIDANDCHEXIANG);
            preparedStatement.setInt(1,trainId);
            preparedStatement.setInt(2, chexiang);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                seat = new Seat();
                seat.setSeatid(resultSet.getInt(1));
                seat.setTrainid(resultSet.getInt(2));
                seat.setDate(resultSet.getDate(3));
                seat.setChexiang(resultSet.getInt(4));
                seat.setSeatno(resultSet.getString(5));
                seat.setFrom(resultSet.getString(6));
                seat.setTo(resultSet.getString(7));
                seat.setStatus(resultSet.getString(8));
                seatList.add(seat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return seatList;
    }

    /**
     * 修改席位信息
     * @param seat  待修改的席位
     * @return  是否修改成功
     */
    @Override
    public boolean updateSeat(Seat seat) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(UPDATESEAT);
            preparedStatement.setInt(1, seat.getTrainid());
            preparedStatement.setDate(2, (Date) seat.getDate());
            preparedStatement.setInt(3, seat.getChexiang());
            preparedStatement.setString(4, seat.getSeatno());
            preparedStatement.setString(5, seat.getFrom());
            preparedStatement.setString(6, seat.getTo());
            preparedStatement.setString(7, seat.getStatus());
            preparedStatement.setInt(8, seat.getSeatid());
            if (1 == preparedStatement.executeUpdate()) {
                DBUtil.closeStatement(preparedStatement);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
        return false;
    }

    /**
     * 根据车次代码和席位售出状态进行客运统计
     * @param trainId   车次代码
     * @param status    席位售出状态
     * @return  对应售出状态席位的数量
     */
    @Override
    public int getSeatsCountByStatus(int trainId,String status) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(GETSEATSCOUNTBYSTATUS);
            preparedStatement.setInt(1,trainId);
            preparedStatement.setString(2,status);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return count;
    }

    /**
     * 根据车次代码按总席位进行客运统计
     * @param trainId   车次代码
     * @return  总席位的数量
     */
    @Override
    public int getAllSeatsCount(int trainId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(GETALLSEATSCOUNT);
            preparedStatement.setInt(1,trainId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return count;
    }
}