package com.csu.servlet.plan;

import com.csu.domain.plan.Plan;
import com.csu.service.PlanService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sx on 2016/9/18.
 */
@WebServlet(name = "PlanServlet", urlPatterns = {"/plan"})
public class PlanServlet extends HttpServlet {
    private static final String planQueryUrl = "WEB-INF/jsp/plan/planQuery.jsp";
    private static final String planAddUrl = "WEB-INF/jsp/plan/planAdd.jsp";

    PlanService planService = new PlanService();

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
        if ("query".equals(function)) {
            //查询
            int queryId = Integer.parseInt(req.getParameter("queryId"));
            String select = req.getParameter("id");
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
        } else if ("add".equals(function)) {
            //跳到增加计划的页面
            //先自动生成计划代码（未写）
            req.getRequestDispatcher(planAddUrl).forward(req, resp);
        } else if ("submitAdd".equals(function)) {
            //提交增加
            int planid = Integer.parseInt(req.getParameter("planid"));
            int trainid = Integer.parseInt(req.getParameter("trainid"));
            int chexiang = Integer.parseInt(req.getParameter("chexiang"));
            String compare = req.getParameter("compare");
            String stationName = req.getParameter("stationName");
            plan = new Plan(planid, trainid, chexiang, compare, stationName);
            planService.insertPlan(plan);
            planList.add(plan);
            session.setAttribute("planList", planList);
            req.getRequestDispatcher(planQueryUrl).forward(req, resp);
        } else if ("modify".equals(function)) {
            //修改计划
            int planid = Integer.parseInt(req.getParameter("planid"));
            plan = planService.getPlanByPlanId(planid);


        } else if ("submitModify".equals(function)) {
            //提交修改

        } else if ("delete".equals(function)) {
            //删除计划
            int planid = Integer.parseInt(req.getParameter("planid"));
            planService.deletePlan(planid);
            session.setAttribute("planList", null);
            req.getRequestDispatcher(planQueryUrl).forward(req, resp);
        }

    }
}
