package com.csu.dao.plan;

import com.csu.domain.plan.Plan;

import java.util.List;

/**
 * Created by sx on 2016/9/14.
 */
public interface PlanDao {
    List<Plan> getAllPlans();//查询所有计划
    Plan getPlanByPlanId(int planId);//根据计划代码查询计划
    List<Plan> getPlansByTrainId(int trainId);  //根据车次代码查询该车次参与的所有计划
    boolean insertPlan(Plan plan); //增
    boolean deletePlan(int planId);//删
    boolean updatePlan(Plan plan); //改
    boolean announceSeat(Plan plan);  //执行计划，发布席位

}
