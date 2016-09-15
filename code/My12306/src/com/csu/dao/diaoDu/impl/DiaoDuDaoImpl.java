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
    private static final String GETSEATSBYTRAINID = "select * from seat where trainid = ?";
    private static final String GETSEATSBYCHEXIANG = "select * from seat where chexiang = ?";
    private static final String UPDATESEAT = "update seat set " +
            "trainid = ?," +    //车次
            "date = ?," +       //日期
            "chexiang = ?," +   //车厢号
            "seatno = ?," +     //座位号
            "from = ?," +       //乘车区间起始站
            "to=?," +           //乘车区间终到站
            "status=? " +       //售票状态
            "where seatid = ?"; //席位代码
    private static final String GETSEATSCOUNTBYSTATUS = "select count(*) from seat where status = ?";
    private static final String GETALLSEATSCOUNT = "select count(*) from seat";

    @Override
    public List<Seat> getSeatsByTrainId(int trainId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Seat> seatList = new ArrayList<>();
        Seat seat = null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(GETSEATSBYTRAINID);
            preparedStatement.setInt(1, trainId);
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

    @Override
    public List<Seat> getSeatsByCheXiang(int chexiang) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Seat> seatList = new ArrayList<>();
        Seat seat = null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(GETSEATSBYCHEXIANG);
            preparedStatement.setInt(1, chexiang);
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

    @Override
    public int getSeatsCountByStatus(String status) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(GETSEATSCOUNTBYSTATUS);
            preparedStatement.setString(1,status);
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

    @Override
    public int getAllSeatsCount() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(GETALLSEATSCOUNT);
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