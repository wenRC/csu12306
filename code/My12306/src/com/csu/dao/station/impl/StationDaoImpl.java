package com.csu.dao.station.impl;

import com.csu.dao.station.StationDAO;
import com.csu.domain.station.Station;
import com.csu.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus_ on 2016/9/18.
 */
public class StationDaoImpl implements StationDAO{
    private static final String GETALLSTATIONS = "select * from station";
    private final static String ADD_STATION = "INSERT INTO STATION(STATIONID,STATIONNAME,PINYIN,LOCATION,JU,`LEVEL`,PHONE) VALUES(?,?,?,?,?,?,?)";
    private final static String GET_STATION_BY_STATIONNAME = "SELECT STATIONID,STATIONNAME,PINYIN,LOCATION,JU,`LEVEL`,PHONE FROM STATION WHERE STATIONNAME = ?";
    private final static String GET_STATION_BY_PINYIN = "SELECT STATIONID,STATIONNAME,PINYIN,LOCATION,JU,`LEVEL`,PHONE FROM STATION WHERE PINYIN = ?";
    private final static String UPDATE_STATION = "UPDATE STATION SET STATIONNAME=?,PINYIN=?,LOCATION=?,JU=?,`LEVEL`=?,PHONE=? WHERE STATIONID = ?";
    private final static String DEL_STATION = "DELETE FROM STATION WHERE STATIONID = ?";
    private final static String GET_MAX_STATIONID = "SELECT MAX(STATIONID) FROM STATION";
    @Override
    public List<Station> getAllStations() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Station> stationList = new ArrayList<>();
        Station station = null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(GETALLSTATIONS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                station = new Station();
                station.setStationId(resultSet.getInt(1));
                station.setStationName(resultSet.getString(2));
                station.setPinYin(resultSet.getString(3));
                station.setLocation(resultSet.getString(4));
                stationList.add(station);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return stationList;
    }

    @Override
    public int addStation(Station station) {
        int i = 0;
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_STATION);
            preparedStatement.setInt(1,station.getStationId());
            preparedStatement.setString(2,station.getStationName());
            preparedStatement.setString(3,station.getPinYin());
            preparedStatement.setString(4,station.getLocation());
            preparedStatement.setString(5,station.getJu());
            preparedStatement.setInt(6,station.getLevel());
            preparedStatement.setString(7,station.getPhone());
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
    public Station getStationByStationName(String stationName) {
        Station station = null;
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_STATION_BY_STATIONNAME);
            preparedStatement.setString(1,stationName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                station = new Station();
                station.setStationId(resultSet.getInt(1));
                station.setStationName(resultSet.getString(2));
                station.setPinYin(resultSet.getString(3));
                station.setLocation(resultSet.getString(4));
                station.setJu(resultSet.getString(5));
                station.setLevel(resultSet.getInt(6));
                station.setPhone(resultSet.getString(7));
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return station;
    }

    @Override
    public Station getStationByPinYin(String pinYin) {
        Station station = null;
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_STATION_BY_PINYIN);
            preparedStatement.setString(1,pinYin);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                station = new Station();
                station.setStationId(resultSet.getInt(1));
                station.setStationName(resultSet.getString(2));
                station.setPinYin(resultSet.getString(3));
                station.setLocation(resultSet.getString(4));
                station.setJu(resultSet.getString(5));
                station.setLevel(resultSet.getInt(6));
                station.setPhone(resultSet.getString(7));
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return station;
    }

    @Override
    public int updateStation(Station station) {
        int i = 0;
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STATION);
            preparedStatement.setString(1,station.getStationName());
            preparedStatement.setString(2,station.getPinYin());
            preparedStatement.setString(3,station.getLocation());
            preparedStatement.setString(4,station.getJu());
            preparedStatement.setInt(5,station.getLevel());
            preparedStatement.setString(6,station.getPhone());
            preparedStatement.setInt(7,station.getStationId());
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
    public int delStation(int stationId) {
        int i = 0;
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DEL_STATION);
            preparedStatement.setInt(1,stationId);
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
    public int getMaxStationId() {
        int i = 0;
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_MAX_STATIONID);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            i = resultSet.getInt(1);
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}