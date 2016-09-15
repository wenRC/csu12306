package com.csu.dao.plan;

import com.csu.domain.plan.Plan;

import java.util.List;

/**
 * Created by sx on 2016/9/14.
 */
public interface PlanDao {
    List<Plan> getAllPlans();
    Plan getPlanByPlanId(int planId);//按照计划代码查询
    List<Plan> getPlansByTrainId(int trainId);  //按照车次代码查询
    boolean insertPlan(Plan plan); //增
    boolean deletePlan(int planId);//删
    boolean updatePlan(Plan plan); //改
    boolean announceSeat(int planId);  //执行计划，发布席位

}
