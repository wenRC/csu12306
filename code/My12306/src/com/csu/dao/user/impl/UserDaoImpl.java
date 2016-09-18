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
    private static final String GET_USER_BY_EMAIL_AND_PASSWORD = "select passengerid,sex,`name`,id,phone,lastlogintime,status from passenger where email=? and password=?";
    private static final String INSERT_USER = "insert into passenger(passengerid,email,password,sex,`name`,id,phone) values(?,?,?,?,?,?,?)";
    private static final String GET_USER_BY_EMAIL = "select `name` from passenger where email=?";
    private static final String UPDATE_USER="update passenger set email=?,password=?,sex=?,`name`=?,id=?,phone=? where passengerid=?";
    @Override
    public boolean insertUser(User user) {
        boolean result = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {


            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_USER);
            preparedStatement.setInt(1, user.getUserid());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getSex());
            preparedStatement.setString(5, user.getUsername());
            preparedStatement.setString(6, user.getId());
            preparedStatement.setString(7, user.getPhone());
            result = preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return result;
    }

    @Override
    public User getUserByEmail(String email) {
        User user = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_USER_BY_EMAIL);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setEmail(email);
                user.setUsername(resultSet.getString("name"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return user;
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        User user = null;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet =null;
        try {
             connection = DBUtil.getConnection();
             preparedStatement = connection.prepareStatement(GET_USER_BY_EMAIL_AND_PASSWORD);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
             resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setEmail(email);
                user.setUsername(resultSet.getString("name"));
                user.setUserid(resultSet.getInt(1));
                user.setSex(resultSet.getString(2));
                user.setId(resultSet.getString(4));
                user.setPhone(resultSet.getString(5));
                user.setLastLoginTime(resultSet.getTimestamp(6));
                user.setPassengerStatus(resultSet.getString(7));
                user.setPassword(password);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return user;
    }

    @Override
    public boolean updateUser(User user) {
        boolean result=false;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection=DBUtil.getConnection();
            preparedStatement=connection.prepareStatement(UPDATE_USER);
            preparedStatement.setString(1,user.getEmail());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getSex());
            preparedStatement.setString(4,user.getUsername());
            preparedStatement.setString(5,user.getId());
            preparedStatement.setString(6,user.getPhone());
            preparedStatement.setInt(7,user.getUserid());
            result=preparedStatement.executeUpdate()==1;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return result;
    }
}
