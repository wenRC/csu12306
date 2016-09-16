package com.csu.dao.order;

import com.csu.domain.order.Order;

import java.util.ArrayList;

/**
 * Created by 温 睿诚 on 2016/9/16/0016.
 */
public interface OrderDao {
    boolean insertOrder(Order order);
    boolean deleteOrder(int orderId);
    boolean updateOrder(Order order);
    ArrayList<Order> getOrdersByUserId(int userId);
    Order getOrderByOrderId(int orderId);

}
