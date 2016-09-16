package com.csu.dao.order.impl;

import com.csu.dao.order.OrderDao;
import com.csu.domain.order.Order;

import java.util.ArrayList;

/**
 * Created by 温 睿诚 on 2016/9/16/0016.
 */
public class OrderDaoImpl implements OrderDao {
    @Override
    public boolean insertOrder(Order order) {
        return false;
    }

    @Override
    public boolean deleteOrder(int orderId) {
        return false;
    }

    @Override
    public boolean updateOrder(Order order) {
        return false;
    }

    @Override
    public ArrayList<Order> getOrdersByUserId(int userId) {
        return null;
    }
}
