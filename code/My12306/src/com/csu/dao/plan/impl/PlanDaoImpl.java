package com.csu.dao.plan.impl;

import com.csu.dao.plan.PlanDao;
import com.csu.dao.train.TrainDao;
import com.csu.dao.train.impl.TrainDaoImpl;
import com.csu.dao.trainGrouped.TrainGroupedDao;
import com.csu.dao.trainGrouped.impl.TrainGroupedDaoImpl;
import com.csu.domain.plan.Plan;
import com.csu.domain.train.Train;
import com.csu.domain.trainGrouped.TrainGrouped;
import com.csu.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sx on 2016/9/14.
 */
public class PlanDaoImpl implements PlanDao {
    private static final String GETALLPLANS = "select * from plan";
    private static final String GETPLANBYPLANID = "select * from plan where planid = ?";
    private static final String GETPLANSBYTRAINID = "select * from plan where trainid = ?";
    private static final String INSERTPLAN = "insert into plan values(?,?,?,?,?)";
    private static final String DELETEPLAN = "delete from plan where planid = ?";
    private static final String UPDATEPLAN = "update plan set " +
            "trainid = ?," +     //车次代码
            "chaxiang = ?," +   //车厢号
            "compare = ?, " + //比较
            "stationname = ?, " +   //车站
            "where planid = ?";  //计划代码
    private static final String ANNOUNCESEAT = "insert into seat values(?,?,?,?,?,?,?,?)";

    /**
     * 查询所有计划
     *
     * @return
     */
    @Override
    public List<Plan> getAllPlans() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Plan> planList = new ArrayList<>();
        Plan plan = null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(GETALLPLANS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                plan = new Plan();
                plan.setPlanid(resultSet.getInt(1));
                plan.setTrainid(resultSet.getInt(2));
                plan.setChexiang(resultSet.getInt(3));
                plan.setCompare(resultSet.getString(4));
                plan.setStationname(resultSet.getString(5));
                planList.add(plan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return planList;
    }

    /**
     * 根据计划代码查询计划
     *
     * @param planId
     * @return
     */
    @Override
    public Plan getPlanByPlanId(int planId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Plan plan = null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(GETPLANBYPLANID);
            preparedStatement.setInt(1, planId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                plan = new Plan();
                plan.setPlanid(resultSet.getInt(1));
                plan.setTrainid(resultSet.getInt(2));
                plan.setChexiang(resultSet.getInt(3));
                plan.setCompare(resultSet.getString(4));
                plan.setStationname(resultSet.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return plan;
    }

    /**
     * 根据车次代码查询该车次参与的所有计划
     *
     * @param trainId 车次代码
     * @return
     */
    @Override
    public List<Plan> getPlansByTrainId(int trainId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Plan> planList = new ArrayList<>();
        Plan plan = null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(GETPLANSBYTRAINID);
            preparedStatement.setInt(1, trainId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                plan = new Plan();
                plan.setPlanid(resultSet.getInt(1));
                plan.setTrainid(resultSet.getInt(2));
                plan.setChexiang(resultSet.getInt(3));
                plan.setCompare(resultSet.getString(4));
                plan.setStationname(resultSet.getString(5));
                planList.add(plan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return planList;
    }

    /**
     * 插入计划
     *
     * @param plan
     * @return
     */
    @Override
    public boolean insertPlan(Plan plan) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(INSERTPLAN);
            preparedStatement.setInt(1, plan.getPlanid());//计划代码
            preparedStatement.setInt(2, plan.getTrainid());//车次代码
            preparedStatement.setInt(3, plan.getChexiang());//车厢
            preparedStatement.setString(4, plan.getCompare());//比较
            preparedStatement.setString(5, plan.getStationname());//车站
            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return false;
    }

    /**
     * 删除计划
     *
     * @param planId 计划代码
     * @return
     */
    @Override
    public boolean deletePlan(int planId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETEPLAN);
            preparedStatement.setInt(1, planId);
            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return false;
    }

    /**
     * 修改计划
     *
     * @param plan
     * @return
     */
    @Override
    public boolean updatePlan(Plan plan) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(UPDATEPLAN);
            preparedStatement.setInt(1, plan.getTrainid());//车次代码
            preparedStatement.setInt(2, plan.getChexiang());//车厢号
            preparedStatement.setString(3, plan.getCompare());//比较
            preparedStatement.setString(4, plan.getStationname());//车站
            preparedStatement.setInt(5, plan.getPlanid());//计划代码
//            if (preparedStatement.executeUpdate() == 1) {
//                return true;
//            }
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return false;
    }

    /**
     * 执行计划，发布席位
     *
     * @param plan 计划
     * @return 发布席位是否成功
     */
    @Override
    public boolean announceSeat(Plan plan) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        TrainDao trainDao = new TrainDaoImpl();
        TrainGroupedDao trainGroupedDao = new TrainGroupedDaoImpl();
        Train train = null;
        TrainGrouped trainGrouped = null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(ANNOUNCESEAT);
            trainGrouped = trainGroupedDao.getTrainGroupBytrainIdAndCheXiang(plan.getTrainid(), plan.getChexiang());//获取列车编组对象
            for (int i = 1; i <= trainGrouped.getSeatNumber(); i++) {
                //在默认车次代码、车厢号、座位号都是两位数或者一位数的情况下，席位代码由五位数或六位数组成，顺序是“车次代码-车厢号-座位号”
                preparedStatement.setInt(1, plan.getTrainid() * 10000 + plan.getChexiang() * 100 + i);//席位代码
                preparedStatement.setInt(2, plan.getTrainid());  //车次
                train = trainDao.getTrainBytrainId(plan.getTrainid()); //根据车次代码获取列车对象
                preparedStatement.setTimestamp(3, train.getFromTime()); //始发日期
                preparedStatement.setInt(4, plan.getChexiang());//车厢号
                preparedStatement.setString(5, "" + i);//座位号
                preparedStatement.setString(6, train.getFrom());//乘车区间起始站
                preparedStatement.setString(7, train.getTo());//乘车区间终到站
                preparedStatement.setString(8, "未售");//售票状态
                if (preparedStatement.executeUpdate() != 1) {
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return true;
    }
}
