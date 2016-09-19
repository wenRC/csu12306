package com.csu.dao.line.impl;

import com.csu.dao.line.LineDAO;
import com.csu.domain.line.Line;
import com.csu.utils.DBUtil;
import com.sun.java.swing.plaf.windows.WindowsBorders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Asus_ on 2016/9/18.
 */
public class LineDAOImpl implements LineDAO{
    private final static String ADD_LINE = "INSERT INTO LINE(LINEID,TRAINID,STATIONNAME,DISTANCE,FROMTIME,STAYTIME) VALUES(?,?,?,?,?,?)";
    private final static String DEL_LINE_BY_LINEID = "DELETE FROM LINE WHERE LINEID = ?";
    private final static String SEARCH_LINE_BY_TRAINID = "SELECT LINEID,TRAINID,STATIONNAME,DISTANCE,FROMTIME,STAYTIME FROM LINE WHERE TRAINID=?";
    private final static String SEARCH_LINE_BY_STATIONNAME = "SELECT LINEID,TRAINID,STATIONNAME,DISTANCE,FROMTIME,STAYTIME FROM LINE WHERE STATIONNAME=?";
    private final static String GET_LINE_BY_LINEID = "SELECT LINEID,TRAINID,STATIONNAME,DISTANCE,FROMTIME,STAYTIME FROM LINE WHERE LINEID=?";
    private final static String UPDATE_LINE = "UPDATE LINE SET TRAINID=?,STATIONNAME=?,DISTANCE=?,FROMTIME=?,STAYTIME=? WHERE LINEID=?";
    private final static String GET_MAX_LINEID = "SELECT MAX(LINEID) FROM LINE";
    @Override
    public int addLine(Line line) {
        int i = 0;
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_LINE);
            preparedStatement.setInt(1,line.getLineId());
            preparedStatement.setInt(2,line.getTrainId());
            preparedStatement.setString(3,line.getStationName());
            preparedStatement.setInt(4,line.getDistance());
            preparedStatement.setDate(5,line.getFromTime());
            preparedStatement.setString(6,line.getLastTime());
            preparedStatement.executeUpdate();
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
            i = 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int delLineByLineId(int lineId) {
        int i = 0;
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DEL_LINE_BY_LINEID);
            preparedStatement.setInt(1,lineId);
            preparedStatement.executeUpdate();
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
            i = 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public ArrayList<Line> searchLineByTrainId(int trainId) {
        ArrayList<Line> lines = new ArrayList<Line>();
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_LINE_BY_TRAINID);
            preparedStatement.setInt(1,trainId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Line line = new Line();
                line.setLineId(resultSet.getInt(1));
                line.setTrainId(resultSet.getInt(2));
                line.setStationName(resultSet.getString(3));
                line.setDistance(resultSet.getInt(4));
                line.setFromTime(resultSet.getDate(5));
                line.setLastTime(resultSet.getString(6));
                lines.add(line);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lines;
    }

    @Override
    public ArrayList<Line> searchLineByStationName(String stationName) {
        ArrayList<Line> lines = new ArrayList<Line>();
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_LINE_BY_STATIONNAME);
            preparedStatement.setString(1,stationName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Line line = new Line();
                line.setLineId(resultSet.getInt(1));
                line.setTrainId(resultSet.getInt(2));
                line.setStationName(resultSet.getString(3));
                line.setDistance(resultSet.getInt(4));
                line.setFromTime(resultSet.getDate(5));
                line.setLastTime(resultSet.getString(6));
                lines.add(line);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lines;
    }

    @Override
    public Line getLineByLineId(int lineId) {
        Line line = null;
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_LINE_BY_LINEID);
            preparedStatement.setInt(1,lineId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                line = new Line();
                line.setLineId(resultSet.getInt(1));
                line.setTrainId(resultSet.getInt(2));
                line.setStationName(resultSet.getString(3));
                line.setDistance(resultSet.getInt(4));
                line.setFromTime(resultSet.getDate(5));
                line.setLastTime(resultSet.getString(6));
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return line;
    }

    @Override
    public int updateLine(Line line) {
        int i = 0;
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_LINE);
            preparedStatement.setInt(1, line.getTrainId());
            preparedStatement.setString(2, line.getStationName());
            preparedStatement.setInt(3, line.getDistance());
            preparedStatement.setDate(4, line.getFromTime());
            preparedStatement.setString(5, line.getLastTime());
            preparedStatement.setInt(6, line.getLineId());
            preparedStatement.executeUpdate();
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
            i = 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int getMaxLineId() {
        int i = 0;
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_MAX_LINEID);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            i = resultSet.getInt(1);
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}
