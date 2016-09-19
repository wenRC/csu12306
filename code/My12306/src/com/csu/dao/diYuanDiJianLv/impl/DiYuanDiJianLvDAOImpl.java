package com.csu.dao.diYuanDiJianLv.impl;

import com.csu.dao.diYuanDiJianLv.DiYuanDiJianLvDAO;
import com.csu.domain.diYuanDiJianLv.DiYuanDiJianLv;
import com.csu.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Asus_ on 2016/9/18.
 */
public class DiYuanDiJianLvDAOImpl implements DiYuanDiJianLvDAO{
    private final static String GET_DYDJL_BY_DYDJID = "SELECT DIYUANDIJIANID,`FROM`,`TO`,RATE,PRICERATE FROM DIYUANDIJIAN WHERE DIYUANDIJIANID = ?";
    private final static String ADD_DYDJL = "INSERT INTO DIYUANDIJIAN(DIYUANDIJIANID,`FROM`,`TO`,RATE,PRICERATE) VALUES(?,?,?,?,?)";
    private final static String GET_DYDJLVS = "SELECT DIYUANDIJIANID,`FROM`,`TO`,RATE,PRICERATE FROM DIYUANDIJIAN";
    private final static String UPDATE_DYDJLV = "UPDATE DIYUANDIJIAN SET DIYUANDIJIANID=?,`FROM`=?,`TO`=?,RATE=?,PRICERATE=? WHERE DIYUANDIJIANID = ?";
    private final static String DEL_DYDJL = "DELETE FROM DIYUANDIJIAN WHERE DIYUANDIJIANID = ?";
    private final static String GET_MAX_DYDJID = "SELECT MAX(DIYUANDIJIANID) FROM DIYUANDIJIAN";
    @Override
    public DiYuanDiJianLv getDYDJLvByDYDJLID(int DYDJLID) {
        DiYuanDiJianLv diYuanDiJianLv = null;
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_DYDJL_BY_DYDJID);
            preparedStatement.setInt(1,DYDJLID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                diYuanDiJianLv = new DiYuanDiJianLv();
                diYuanDiJianLv.setdYDJId(resultSet.getInt(1));
                diYuanDiJianLv.setdYDJFrom(resultSet.getString(2));
                diYuanDiJianLv.setdYDJTo(resultSet.getString(3));
                diYuanDiJianLv.setdYDJRate(resultSet.getDouble(4));
                diYuanDiJianLv.setPriceRate(resultSet.getDouble(5));
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diYuanDiJianLv;
    }

    @Override
    public int addDYDJLv(DiYuanDiJianLv diYuanDiJianLv) {
        int i = 0;//0表示失败
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_DYDJL);
            preparedStatement.setInt(1,diYuanDiJianLv.getdYDJId());
            preparedStatement.setString(2,diYuanDiJianLv.getdYDJFrom());
            preparedStatement.setString(3,diYuanDiJianLv.getdYDJTo());
            preparedStatement.setDouble(4,diYuanDiJianLv.getdYDJRate());
            preparedStatement.setDouble(5,diYuanDiJianLv.getPriceRate());
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
    public ArrayList<DiYuanDiJianLv> getDYDJLvs() {
        ArrayList<DiYuanDiJianLv> diYuanDiJianLvs = new ArrayList<DiYuanDiJianLv>();
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_DYDJLVS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                DiYuanDiJianLv diYuanDiJianLv = new DiYuanDiJianLv();
                diYuanDiJianLv.setdYDJId(resultSet.getInt(1));
                diYuanDiJianLv.setdYDJFrom(resultSet.getString(2));
                diYuanDiJianLv.setdYDJTo(resultSet.getString(3));
                diYuanDiJianLv.setdYDJRate(resultSet.getDouble(4));
                diYuanDiJianLv.setPriceRate(resultSet.getDouble(5));
                diYuanDiJianLvs.add(diYuanDiJianLv);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diYuanDiJianLvs;
    }

    @Override
    public int updateDYDJLv(DiYuanDiJianLv diYuanDiJianLv) {
        int i = 0;//0表示失败
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DYDJLV);
            preparedStatement.setInt(1,diYuanDiJianLv.getdYDJId());
            preparedStatement.setString(2,diYuanDiJianLv.getdYDJFrom());
            preparedStatement.setString(3,diYuanDiJianLv.getdYDJTo());
            preparedStatement.setDouble(4,diYuanDiJianLv.getdYDJRate());
            preparedStatement.setDouble(5,diYuanDiJianLv.getPriceRate());
            preparedStatement.setInt(6,diYuanDiJianLv.getdYDJId());
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
    public int delDYDJLvById(int DYDJLID) {
        int i = 0;
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DEL_DYDJL);
            preparedStatement.setInt(1,DYDJLID);
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
    public int getMaxDYDJLId() {
        int i = 0;
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_MAX_DYDJID);
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

    public static void main(String[] args){
        DiYuanDiJianLvDAO diYuanDiJianLvDAO = new DiYuanDiJianLvDAOImpl();
        System.out.println(diYuanDiJianLvDAO.getDYDJLvByDYDJLID(2).getdYDJFrom());
    }
}
