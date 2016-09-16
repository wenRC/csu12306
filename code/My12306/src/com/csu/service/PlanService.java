package com.csu.service;

import com.csu.dao.plan.PlanDao;
import com.csu.dao.plan.impl.PlanDaoImpl;
import com.csu.domain.plan.Plan;

import java.util.List;

/**
 * Created by 温 睿诚 on 2016/9/16/0016.
 */
public class PlanService {
    private PlanDao planDao;
    public PlanService(){
        planDao=new PlanDaoImpl();
    }

    List<Plan> getAllPlans(){
        return planDao.getAllPlans();
    }//查询所有计划
    Plan getPlanByPlanId(int planId){
        return planDao.getPlanByPlanId(planId);
    }//根据计划代码查询计划
    List<Plan> getPlansByTrainId(int trainId){
        return planDao.getPlansByTrainId(trainId);
    } //根据车次代码查询该车次参与的所有计划
    boolean insertPlan(Plan plan){
        return planDao.insertPlan(plan);
    }//增
    boolean deletePlan(int planId){
        return planDao.deletePlan(planId);
    }//删
    boolean updatePlan(Plan plan){
        return planDao.updatePlan(plan);
    } //改
    boolean announceSeat(Plan plan){
        return planDao.announceSeat(plan);
    } //执行计划，发布席位
}
