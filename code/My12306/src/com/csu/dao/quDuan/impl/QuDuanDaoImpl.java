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
    private static final String GETALLQUDUANS = "select * from quDuan";
    private static final String GETQUDUANBYID = "select * from quDuan where quduanid = ?";
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
                quDuan.setQuDuanId(resultSet.getInt(1));
                quDuan.setFrom(resultSet.getString(2));
                quDuan.setTo(resultSet.getString(3));
                quDuan.setDistancePerQD(resultSet.getInt(4));
                quDuan.setQdNumber(resultSet.getInt(5));
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

    @Override
    public QuDuan getQuDuanById(int quDuanId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        return null;
    }

    @Override
    public void updateQuDuan(QuDuan quDuan) {

    }
}
