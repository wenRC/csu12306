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
    boolean insertOrder(Order order){
        return orderDao.insertOrder(order);
    }
    boolean deleteOrder(int orderId){
        return orderDao.deleteOrder(orderId);
    }
    boolean updateOrder(Order order){
        return updateOrder(order);
    }
    ArrayList<Order> getOrdersByUserId(int userId){
        return orderDao.getOrdersByUserId(userId);
    }
    Order getOrderByOrderId(int orderId){
        return orderDao.getOrderByOrderId(orderId);
    }
}
