package com.csu.dao.quDuan.impl;

import com.csu.dao.quDuan.QuDuanDao;
import com.csu.domain.quDuan.QuDuan;
import com.csu.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sx on 2016/9/12.
 */
public class QuDuanDaoImpl implements QuDuanDao {
    private static final String GETALLQUDUANS = "select * from quduan";
    private static final String GETQUDUANBYID = "select * from quduan where quduanid = ?";
    private static final String UPDATEQUDUAN = "update quduan set " +
            "from=?," +     //里程区段From
            "to=?," +       //里程区段To
            "distanceperqd=?," +    //每区段里程
            "qdnumber=? " +         //区段数
            "where quduanid=?";     //旅程区段编号

    /**
     * 查询所有的区段
     * @return
     */
    @Override
    public List<QuDuan> getAllQuDuans() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        QuDuan quDuan = null;
        List<QuDuan> quDuanList = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(GETALLQUDUANS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                quDuan = new QuDuan();
                quDuan.setQuDuanId(resultSet.getInt(1));//旅程区段编号
                quDuan.setFrom(resultSet.getString(2));//里程区段From
                quDuan.setTo(resultSet.getString(3));//里程区段To
                quDuan.setDistancePerQD(resultSet.getInt(4));//每区段里程
                quDuan.setQdNumber(resultSet.getInt(5));//区段数
                quDuanList.add(quDuan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return quDuanList;
    }

    /**
     * 根据旅程区段编号查询区段
     * @param quDuanId
     * @return
     */
    @Override
    public QuDuan getQuDuanById(int quDuanId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        QuDuan quDuan = null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(GETQUDUANBYID);
            preparedStatement.setInt(1,quDuanId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                quDuan = new QuDuan();
                quDuan.setQuDuanId(resultSet.getInt(1));//旅程区段编号
                quDuan.setFrom(resultSet.getString(2));//里程区段From
                quDuan.setTo(resultSet.getString(3));//里程区段To
                quDuan.setDistancePerQD(resultSet.getInt(4));//每区段里程
                quDuan.setQdNumber(resultSet.getInt(5));//区段数
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return quDuan;
    }

    @Override
    public boolean updateQuDuan(QuDuan quDuan) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(UPDATEQUDUAN);
            preparedStatement.setString(1, quDuan.getFrom());//里程区段From
            preparedStatement.setString(2, quDuan.getTo());//里程区段To
            preparedStatement.setInt(3, quDuan.getDistancePerQD());//每区段里程
            preparedStatement.setInt(4, quDuan.getQdNumber());//区段数
            preparedStatement.setInt(5, quDuan.getQuDuanId());//旅程区段编号
            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return false;
    }
}
