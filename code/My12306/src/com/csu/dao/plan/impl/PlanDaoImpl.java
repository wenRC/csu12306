package com.csu.dao.plan.impl;

import com.csu.dao.plan.PlanDao;
import com.csu.domain.plan.Plan;
import com.csu.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    @Override
    public List<Plan> getAllPlans() {
        Connection connection= null;
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

    @Override
    public Plan getPlanByPlanId(int planId) {
        Connection connection= null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Plan plan = null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(GETPLANBYPLANID);
            preparedStatement.setInt(1,planId);
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

    @Override
    public List<Plan> getPlansByTrainId(int trainId) {
        Connection connection= null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Plan> planList = new ArrayList<>();
        Plan plan = null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(GETPLANSBYTRAINID);
            preparedStatement.setInt(1,trainId);
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

    @Override
    public boolean insertPlan(Plan plan) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(INSERTPLAN);
            preparedStatement.setInt(1,plan.getPlanid());
            preparedStatement.setInt(2,plan.getTrainid());
            preparedStatement.setInt(3,plan.getChexiang());
            preparedStatement.setString(4,plan.getCompare());
            preparedStatement.setString(5,plan.getStationname());
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

    @Override
    public boolean deletePlan(int planId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETEPLAN);
            preparedStatement.setInt(1,planId);
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

    @Override
    public boolean updatePlan(Plan plan) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(UPDATEPLAN);
            preparedStatement.setInt(1,plan.getTrainid());
            preparedStatement.setInt(2,plan.getChexiang());
            preparedStatement.setString(3,plan.getCompare());
            preparedStatement.setString(4,plan.getStationname());
            preparedStatement.setInt(5,plan.getPlanid());
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

    @Override
    public boolean announceSeat(int planId) {
        return false;
    }
}
