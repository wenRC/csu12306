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
    private static final String GETSEATBYSEATID = "select * from seat where seatid = ?";
    private static final String GETSEATSBYTRAINIDANDCHEXIANG = "select * from seat where trainid = ? and chexiang = ?";
    private static final String GETSEATSBYTRAINID = "select * from seat where trainid = ?";
    private static final String GETALLSEATS = "select * from seat";
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
    private static final String GET_SEAT_BY_SEATID="select trainid,`date`,chexiang,seatno,`from`,`to`,status from seat where seatid=?";
    /**
     * 按照席位代码进行查询
     *
     * @param seatid
     * @return
     */
    @Override
    public Seat getSeatBySeatId(int seatid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Seat seat = null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(GETSEATBYSEATID);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                seat = new Seat();
                seat.setSeatid(resultSet.getInt(1));//席位代码
                seat.setTrainid(resultSet.getInt(2));//车次代码
                seat.setDate(resultSet.getTimestamp(3));//日期
                seat.setChexiang(resultSet.getInt(4));//车厢号
                seat.setSeatno(resultSet.getString(5));//座位号
                seat.setFrom(resultSet.getString(6));//乘车区间起始站
                seat.setTo(resultSet.getString(7));//乘车区间终到站
                seat.setStatus(resultSet.getString(8));//售票状态
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return seat;
    }

    /**
     * 按照车次、车厢查询席位信息
     *
     * @param trainId  车次
     * @param chexiang 车厢号
     * @return 席位信息集合
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
            preparedStatement.setInt(1, trainId);
            preparedStatement.setInt(2, chexiang);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                seat = new Seat();
                seat.setSeatid(resultSet.getInt(1));//席位代码
                seat.setTrainid(resultSet.getInt(2));//车次代码
                seat.setDate(resultSet.getTimestamp(3));//日期
                seat.setChexiang(resultSet.getInt(4));//车厢号
                seat.setSeatno(resultSet.getString(5));//座位号
                seat.setFrom(resultSet.getString(6));//乘车区间起始站
                seat.setTo(resultSet.getString(7));//乘车区间终到站
                seat.setStatus(resultSet.getString(8));//售票状态
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
     * 按照车次代码查询席位信息
     *
     * @param trainId
     * @return 席位信息集合
     */
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
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                seat = new Seat();
                seat.setSeatid(resultSet.getInt(1));//席位代码
                seat.setTrainid(resultSet.getInt(2));//车次代码
                seat.setDate(resultSet.getTimestamp(3));//日期
                seat.setChexiang(resultSet.getInt(4));//车厢号
                seat.setSeatno(resultSet.getString(5));//座位号
                seat.setFrom(resultSet.getString(6));//乘车区间起始站
                seat.setTo(resultSet.getString(7));//乘车区间终到站
                seat.setStatus(resultSet.getString(8));//售票状态
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
     * 查询出所有的席位信息
     *
     * @return 席位信息集合
     */
    @Override
    public List<Seat> getAllSeats() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Seat> seatList = new ArrayList<>();
        Seat seat = null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(GETALLSEATS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                seat = new Seat();
                seat.setSeatid(resultSet.getInt(1));//席位代码
                seat.setTrainid(resultSet.getInt(2));//车次代码
                seat.setDate(resultSet.getTimestamp(3));//日期
                seat.setChexiang(resultSet.getInt(4));//车厢号
                seat.setSeatno(resultSet.getString(5));//座位号
                seat.setFrom(resultSet.getString(6));//乘车区间起始站
                seat.setTo(resultSet.getString(7));//乘车区间终到站
                seat.setStatus(resultSet.getString(8));//售票状态
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
     *
     * @param seat 待修改的席位
     * @return 是否修改成功
     */
    @Override
    public boolean updateSeat(Seat seat) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(UPDATESEAT);
            preparedStatement.setInt(1, seat.getTrainid());//车次代码
            preparedStatement.setTimestamp(2, seat.getDate());//日期
            preparedStatement.setInt(3, seat.getChexiang());//车厢号
            preparedStatement.setString(4, seat.getSeatno());//座位号
            preparedStatement.setString(5, seat.getFrom());//乘车区间起始站
            preparedStatement.setString(6, seat.getTo());//乘车区间终到站
            preparedStatement.setString(7, seat.getStatus());//售票状态
            preparedStatement.setInt(8, seat.getSeatid());//席位代码
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
     *
     * @param trainId 车次代码
     * @param status  席位售出状态
     * @return 对应售出状态席位的数量
     */
    @Override
    public int getSeatsCountByStatus(int trainId, String status) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(GETSEATSCOUNTBYSTATUS);
            preparedStatement.setInt(1, trainId);
            preparedStatement.setString(2, status);
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
     *
     * @param trainId 车次代码
     * @return 总席位的数量
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
            preparedStatement.setInt(1, trainId);
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
    public Seat getSeatBySeatId(int seatId) {
        Seat seat=null;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            connection=DBUtil.getConnection();
            preparedStatement=connection.prepareStatement(GET_SEAT_BY_SEATID);
            preparedStatement.setInt(1,seatId);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                seat=new Seat();
                seat.setSeatid(seatId);
                seat.setTrainid(resultSet.getInt(1));
                seat.setDate(resultSet.getTimestamp(2));
                seat.setChexiang(resultSet.getInt(3));
                seat.setSeatno(resultSet.getString(4));
                seat.setFrom(resultSet.getString(5));
                seat.setTo(resultSet.getString(6));
                seat.setStatus(resultSet.getString(7));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return seat;
    }
}