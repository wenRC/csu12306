package com.csu.dao.train.impl;

import com.csu.dao.train.TrainDao;
import com.csu.domain.train.Train;
import com.csu.utils.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sx on 2016/9/15.
 */
public class TrainDaoImpl implements TrainDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    private static final String GET_ALLTRAINS = "select * from train";
    private static final String GET_TRAIN = "select * from train where trainid = ?";
    private static final String INSERT_TRAIN = "insert into train VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String DELETE_TRAIN = "delete from train where trainid = ?";
    private static final String UPDATE_TRAIN = "update train set `from` = ?,`to` = ?,fromtime = ?,totime = ?,last = ?,distance = ?,noseatnumber = ?,type = ? where trainid = ?";

    @Override
    public List<Train> getAllTrains() {
        Train train = null;
        List<Train> trains = null;
        trains = new LinkedList<>();
        try{
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_ALLTRAINS);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                train = new Train();
                train.setTrainId(resultSet.getInt(1));
                train.setFrom(resultSet.getString(2));
                train.setTo(resultSet.getString(3));
                train.setFromTime(resultSet.getTimestamp(4));
                train.setToTime(resultSet.getTimestamp(5));
                train.setLast(resultSet.getString(6));
                train.setDistance(resultSet.getInt(7));
                train.setNoseatnumber(resultSet.getInt(8));
                train.setType(resultSet.getString(9));
                trains.add(train);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return trains;

    }

    @Override
    public Train getTrainBytrainId(int trainId) {
        Train train = null;
        try{
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_TRAIN);
            preparedStatement.setInt(1,trainId);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                train = new Train();
                train.setTrainId(resultSet.getInt(1));
                train.setFrom(resultSet.getString(2));
                train.setTo(resultSet.getString(3));
                train.setFromTime(resultSet.getTimestamp(4));
                train.setToTime(resultSet.getTimestamp(5));
                train.setLast(resultSet.getString(6));
                train.setDistance(resultSet.getInt(7));
                train.setNoseatnumber(resultSet.getInt(8));
                train.setType(resultSet.getString(9));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return train;
    }

    @Override
    public boolean insertTrain(Train train) {
        boolean result = false;
        try{
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_TRAIN);
            preparedStatement.setInt(1,train.getTrainId());
            preparedStatement.setString(2,train.getFrom());
            preparedStatement.setString(3,train.getTo());
            preparedStatement.setTimestamp(4,train.getFromTime());
            preparedStatement.setTimestamp(5,train.getToTime());
            preparedStatement.setString(6,train.getLast());
            preparedStatement.setInt(7,train.getDistance());
            preparedStatement.setInt(8,train.getNoseatnumber());
            preparedStatement.setString(9,train.getType());
            result=preparedStatement.executeUpdate()==1;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return result;
    }

    @Override
    //如果要删除的列车已经增加编组、线路信息，不能删除。
    public boolean deleteTrainBytrainId(int trainId) {
        boolean result = false;
        try{
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_TRAIN);
            preparedStatement.setInt(1,trainId);
            result=preparedStatement.executeUpdate()==1;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return result;
    }

    @Override
    public boolean updateTrain(Train train) {
        boolean result = false;
        try{
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_TRAIN);
            preparedStatement.setString(1,train.getFrom());
            preparedStatement.setString(2,train.getTo());
            preparedStatement.setTimestamp(3,train.getFromTime());
            preparedStatement.setTimestamp(4,train.getToTime());
            preparedStatement.setString(5,train.getLast());
            preparedStatement.setInt(6,train.getDistance());
            preparedStatement.setInt(7,train.getNoseatnumber());
            preparedStatement.setString(8,train.getType());
            preparedStatement.setInt(9,train.getTrainId());
            result=preparedStatement.executeUpdate()==1;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return result;
    }
}
