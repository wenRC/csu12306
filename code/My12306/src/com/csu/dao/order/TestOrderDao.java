package com.csu.dao.order;

import com.csu.dao.order.OrderDao;
import com.csu.dao.order.impl.OrderDaoImpl;
import com.csu.domain.order.Order;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Created by 温 睿诚 on 2016/9/17/0017.
 */
public class TestOrderDao {
    public static void main(String[] args){
        OrderDao orderDao=new OrderDaoImpl();
        //通过测试
        //insert
//        Order order=new Order(2,1,"已支付",new Timestamp(System.currentTimeMillis()));
//        System.out.println(orderDao.insertOrder(order));
        //delete
//        System.out.println(orderDao.deleteOrder(2));
//
        //update
//        Order order=new Order(1,1,"未支付",new Timestamp(System.currentTimeMillis()));
//        System.out.println(orderDao.updateOrder(order));
        //get order by userid
//        ArrayList<Order> orders=orderDao.getOrdersByUserId(1);
//        System.out.println(orders.get(0).getOrderTime());
        //get order by orderid
//        System.out.println(orderDao.getOrderByOrderId(1).getOrderTime());


    }
}
