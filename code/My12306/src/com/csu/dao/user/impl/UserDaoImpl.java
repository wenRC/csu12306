package com.csu.dao.user.impl;

import com.csu.dao.user.UserDao;
import com.csu.domain.user.User;
import com.csu.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 温 睿诚 on 2016/9/14/0014.
 */
public class UserDaoImpl implements UserDao {
    private static  final String GET_USER_BY_EMAIL_AND_PASSWORD="select * from passenger where email=? and password=?";
    @Override
    public boolean insertUser(User user) {
        return false;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        User user=null;
        try {
            Connection connection= DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(GET_USER_BY_EMAIL_AND_PASSWORD);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                user=new User();
                user.setEmail(email);
                user.setUsername(resultSet.getString("name"));
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }
}
