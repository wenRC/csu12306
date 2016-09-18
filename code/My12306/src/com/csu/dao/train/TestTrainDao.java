package com.csu.dao.train;

import com.csu.dao.order.OrderDao;
import com.csu.dao.order.impl.OrderDaoImpl;
import com.csu.dao.train.impl.TrainDaoImpl;

/**
 * Created by war on 2016/9/18.
 */
    public class TestTrainDao {
        public static void main(String[] args) {
            TrainDao trainDao = new TrainDaoImpl();
            System.out.println(trainDao.getAllTrains().get(0).getFrom());
        }}
