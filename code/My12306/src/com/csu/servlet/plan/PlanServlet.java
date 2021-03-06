package com.csu.servlet.plan;

import com.csu.domain.plan.Plan;
import com.csu.domain.station.Station;
import com.csu.domain.train.Train;
import com.csu.service.BaseService;
import com.csu.service.PlanService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sx on 2016/9/18.
 */
@WebServlet(name = "PlanServlet", urlPatterns = {"/plan"})
public class PlanServlet extends HttpServlet {
    private static final String planQueryUrl = "WEB-INF/jsp/plan/planQuery.jsp";
    private static final String planAddUrl = "WEB-INF/jsp/plan/planAdd.jsp";
    private static final String planModifyUrl = "WEB-INF/jsp/plan/planModify.jsp";

    PlanService planService = new PlanService();
    BaseService baseService = new BaseService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String function = req.getParameter("function");
        HttpSession session = req.getSession();
        List<Plan> planList = new ArrayList<>();
        Plan plan = null;
        String success = null;
        String fail = null;
        if ("query".equals(function)) {
            //查询
            int queryId = Integer.parseInt(req.getParameter("queryId"));
            String select = req.getParameter("queryMethod");
            if ("plan".equals(select)) {
                //根据计划代码查询
                plan = planService.getPlanByPlanId(queryId);
                planList.add(plan);
            } else {
                //根据车次代码查询
                planList = planService.getPlansByTrainId(queryId);
            }
            session.setAttribute("planList", planList);
            req.getRequestDispatcher(planQueryUrl).forward(req, resp);
        } else if ("queryAll".equals(function)) {
            //显示所有计划
            planList = planService.getAllPlans();
            session.setAttribute("planList",planList);
            req.getRequestDispatcher(planQueryUrl).forward(req, resp);
        }
        else if ("add".equals(function)) {
            //跳到增加计划的页面
            List<Train> trainList = baseService.getAllTrains();
            List<Station> stationList = baseService.getAllStations();
            session.setAttribute("trainList",trainList);
            session.setAttribute("stationList",stationList);
            req.getRequestDispatcher(planAddUrl).forward(req, resp);
        } else if ("submitAdd".equals(function)) {
            //提交增加
            int planid = Integer.parseInt(req.getParameter("planid"));
            int trainid = Integer.parseInt(req.getParameter("trainid"));
            int chexiang = Integer.parseInt(req.getParameter("chexiang"));
            String compare = req.getParameter("compare");
            String stationName = req.getParameter("stationName");
            plan = new Plan(planid, trainid, chexiang, compare, stationName);
            boolean flag = planService.insertPlan(plan);
            if (flag) {
                success = "添加成功";
                req.setAttribute("success",success);
            } else {
                fail = "添加失败";
                req.setAttribute("fail",fail);
            }
            planList = planService.getAllPlans();
            session.setAttribute("planList", planList);

            req.getRequestDispatcher(planQueryUrl).forward(req, resp);
        } else if ("modify".equals(function)) {
            //修改计划
            int planid = Integer.parseInt(req.getParameter("planid"));
            plan = planService.getPlanByPlanId(planid);
            List<Train> trainList = baseService.getAllTrains();
            Train train = baseService.getTrainBytrainId(plan.getTrainid());
            List<String> stationNameList = new ArrayList<>();
            stationNameList.add(train.getFrom());
            stationNameList.add(train.getTo());
            session.setAttribute("trainList",trainList);
            session.setAttribute("stationNameList",stationNameList);
            session.setAttribute("plan",plan);
            req.getRequestDispatcher(planModifyUrl).forward(req,resp);
        } else if ("submitModify".equals(function)) {
            //提交修改
            int planid = Integer.parseInt(req.getParameter("planid"));
            int trainid = Integer.parseInt(req.getParameter("trainid"));
            int chexiang = Integer.parseInt(req.getParameter("chexiang"));
            String compare = req.getParameter("compare");
            String stationname = req.getParameter("stationName");
            plan = new Plan(planid,trainid,chexiang,compare,stationname);
            boolean flag = planService.updatePlan(plan);
            if (flag) {
                success = "修改成功";
                req.setAttribute("success",success);
            } else {
                fail = "修改失败";
                req.setAttribute("fail",fail);
            }
            planList.add(plan);
            session.setAttribute("planList",planList);
            req.getRequestDispatcher(planQueryUrl).forward(req, resp);
        } else if ("delete".equals(function)) {
            //删除计划
            int planid = Integer.parseInt(req.getParameter("planid"));
            boolean flag = planService.deletePlan(planid);
            if (flag) {
                success = "删除成功";
                req.setAttribute("success",success);
            } else {
                fail = "删除失败";
                req.setAttribute("fail",fail);
            }
            planList = planService.getAllPlans();
            session.setAttribute("planList",planList);
            req.getRequestDispatcher(planQueryUrl).forward(req, resp);
        }
    }
}
