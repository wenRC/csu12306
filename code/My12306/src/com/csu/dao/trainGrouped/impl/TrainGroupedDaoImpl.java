package com.csu.dao.trainGrouped.impl;

import com.csu.dao.trainGrouped.TrainGroupedDao;
import com.csu.domain.trainGrouped.TrainGrouped;
import com.csu.utils.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by sx on 2016/9/15.
 */
public class TrainGroupedDaoImpl implements TrainGroupedDao {
    private static String GET_TRAINGROUP_BY_TRAINID = "select * from traingroup where trainid = ?";
    private static String GET_TRAINGROUP = "select * from traingroup where trainid = ? and chexiang = ? ";
    private static String INSERT_TRAINGROUP = "insert into traingroup VALUES (?,?,?,?,?,?)";
    private static String DELETE_TRAINGROUP = "delete from traingroup where trainid = ? and chexiang = ?";
    private static String UPDATE_TRAINGROUP = "update traingroup set trainid = ?,chexiang = ?,seattype = ?,seatnumber = ?,chexiangtype = ? where traingroupid = ?";
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public ArrayList<TrainGrouped> getTrainGroupBytrainId(int trainId) {
        TrainGrouped trainGrouped = null;
        ArrayList<TrainGrouped> trainGroupeds= null;
        try{
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_TRAINGROUP_BY_TRAINID);
            preparedStatement.setInt(1,trainId);
            resultSet = preparedStatement.executeQuery();
            trainGroupeds = new ArrayList<TrainGrouped>();
            while(resultSet.next()){
                trainGrouped = new TrainGrouped();
                trainGrouped.setTrainGroupId(resultSet.getInt(1));
                trainGrouped.setTrainId(resultSet.getInt(2));
                trainGrouped.setChexiang(resultSet.getInt(3));
                trainGrouped.setSeatType(resultSet.getString(4));
                trainGrouped.setSeatNumber(resultSet.getInt(5));
                trainGrouped.setChexiangType(resultSet.getString(6));
                trainGroupeds.add(trainGrouped);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeConnection(connection);
        }
        return trainGroupeds;
    }

    @Override
    public TrainGrouped getTrainGroupBytrainIdAndCheXiang(int trainId, int chexiang) {
        TrainGrouped trainGrouped = null;
        try{
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_TRAINGROUP);
            preparedStatement.setInt(1,trainId);
            preparedStatement.setInt(2,chexiang);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                trainGrouped = new TrainGrouped();
                trainGrouped.setTrainGroupId(resultSet.getInt(1));
                trainGrouped.setTrainId(resultSet.getInt(2));
                trainGrouped.setChexiang(resultSet.getInt(3));
                trainGrouped.setSeatType(resultSet.getString(4));
                trainGrouped.setSeatNumber(resultSet.getInt(5));
                trainGrouped.setChexiangType(resultSet.getString(6));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeConnection(connection);
        }
        return trainGrouped;
    }

    @Override
    public boolean insertTrainGroup(TrainGrouped trainGroup) {
        boolean result = false;
        try{
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_TRAINGROUP);
            preparedStatement.setInt(1,trainGroup.getTrainGroupId());
            preparedStatement.setInt(2, trainGroup.getTrainId());
            preparedStatement.setInt(3, trainGroup.getChexiang());
            preparedStatement.setString(4, trainGroup.getSeatType());
            preparedStatement.setInt(5, trainGroup.getSeatNumber());
            preparedStatement.setString(6,trainGroup.getChexiangType());
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
    //如果要删除的车站已经售票，不能删除。
    public boolean deleteTrainGroupBytrainIdAndCheXiang(int trainId, int chexiang) {
        boolean result = false;
        try{
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_TRAINGROUP);
            preparedStatement.setInt(1,trainId);
            preparedStatement.setInt(2,chexiang);
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
    public boolean updateTrainGroup(TrainGrouped trainGroup) {
        boolean result = false;
        try{
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_TRAINGROUP);
            preparedStatement.setInt(1, trainGroup.getTrainId());
            preparedStatement.setInt(2, trainGroup.getChexiang());
            preparedStatement.setString(3, trainGroup.getSeatType());
            preparedStatement.setInt(4, trainGroup.getSeatNumber());
            preparedStatement.setString(5,trainGroup.getChexiangType());
            preparedStatement.setInt(6,trainGroup.getTrainGroupId());
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
}
