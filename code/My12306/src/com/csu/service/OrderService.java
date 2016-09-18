package com.csu.service;

import com.csu.dao.order.OrderDao;
import com.csu.dao.order.impl.OrderDaoImpl;
import com.csu.domain.order.Order;

import java.util.ArrayList;

/**
 * Created by 温 睿诚 on 2016/9/16/0016.
 */
public class OrderService {
    private OrderDao orderDao;
    public OrderService() {
        orderDao=new OrderDaoImpl();
    }
    public boolean insertOrder(Order order){
        return orderDao.insertOrder(order);
    }
    public boolean deleteOrder(int orderId){
        return orderDao.deleteOrder(orderId);
    }
    public boolean updateOrder(Order order){
        return updateOrder(order);
    }
    public ArrayList<Order> getOrdersByUserId(int userId){
        return orderDao.getOrdersByUserId(userId);
    }
    public Order getOrderByOrderId(int orderId){
        return orderDao.getOrderByOrderId(orderId);
    }
}
