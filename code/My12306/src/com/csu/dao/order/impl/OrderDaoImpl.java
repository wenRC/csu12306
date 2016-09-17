package com.csu.dao.order.impl;

import com.csu.dao.order.OrderDao;
import com.csu.domain.order.Order;
import com.csu.utils.DBUtil;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by 温 睿诚 on 2016/9/16/0016.
 */
public class OrderDaoImpl implements OrderDao {
    private static final  String INSERT_ORDER="insert into `order` values(?,?,?,?)";
    private static final  String DELETE_ORDER="DELETE FROM `ORDER` WHERE orderid=?";
    private static final  String UPDATE_ORDER="update `order` set passengerid=?,orderstatus=?,ordertime=? where orderid=?";
    private static final  String GET_ORDERS_BY_USERID="select orderid,orderstatus,ordertime from `order` where passengerid=?";
    private static final  String GET_ORDER_BY_ORDERID="SELECT passengerid,orderstatus,ordertime from `order` where orderid=?";

    @Override
    public boolean insertOrder(Order order) {
        boolean result=false;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
             connection = DBUtil.getConnection();
             preparedStatement = connection.prepareStatement(INSERT_ORDER);
            preparedStatement.setInt(1,order.getOrderId());
            preparedStatement.setInt(2,order.getPassengerId());
            preparedStatement.setString(3,order.getOrderStatus());
            preparedStatement.setTimestamp(4,order.getOrderTime());
            result=preparedStatement.executeUpdate()==1?true:false;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return result;
    }

    @Override
    public boolean deleteOrder(int orderId) {
        boolean result=false;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_ORDER);
            preparedStatement.setInt(1,orderId);

            result=preparedStatement.executeUpdate()==1;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return result;
    }

    @Override
    public boolean updateOrder(Order order) {
        boolean result=false;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_ORDER);
            preparedStatement.setInt(1,order.getPassengerId());
            preparedStatement.setString(2,order.getOrderStatus());
            preparedStatement.setTimestamp(3,order.getOrderTime());
            preparedStatement.setInt(4,order.getOrderId());
            result=preparedStatement.executeUpdate()==1?true:false;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return result;
    }

    @Override
    public ArrayList<Order> getOrdersByUserId(int userId) {
        ArrayList<Order> orders=new ArrayList<>();
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_ORDERS_BY_USERID);
            preparedStatement.setInt(1,userId);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Order order=new Order();
                order.setOrderId(resultSet.getInt(1));
                order.setPassengerId(userId);
                order.setOrderStatus(resultSet.getString(2));
                order.setOrderTime(resultSet.getTimestamp(3));
                orders.add(order);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return orders;
    }

    @Override
    public Order getOrderByOrderId(int orderId) {
        Order order=null;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_ORDER_BY_ORDERID);
            preparedStatement.setInt(1,orderId);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                order=new Order();
                order.setOrderId(orderId);
                order.setPassengerId(resultSet.getInt(1));
                order.setOrderStatus(resultSet.getString(2));
                order.setOrderTime(resultSet.getTimestamp(3));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return order;
    }
}
