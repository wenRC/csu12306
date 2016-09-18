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
@WebServlet(name = "PlanServlet",urlPatterns = {"/plan"})
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
            //
            int queryId = Integer.parseInt(req.getParameter("queryId"));
            String select = req.getParameter("id");
            if ("plan".equals(select)) {
                plan = planService.getPlanByPlanId(queryId);
                planList.add(plan);
            } else {
                planList = planService.getPlansByTrainId(queryId);
            }
            session.setAttribute("planList",planList);
            req.getRequestDispatcher(planQueryUrl).forward(req,resp);
        } else if ("add".equals(function)) {

            req.getRequestDispatcher(planAddUrl).forward(req,resp);
        } else if ("submitAdd".equals(function)) {

        }

    }
}
