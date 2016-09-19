package com.csu.servlet.main;

import com.csu.domain.diaoDu.Seat;
import com.csu.domain.plan.Plan;
import com.csu.service.DiaoduService;
import com.csu.service.PlanService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by sx on 2016/9/18.
 */
@WebServlet(name = "ToServlet",urlPatterns = {"/to"})
public class ToServlet extends HttpServlet {
    private static final String toQuDuanAdminUrl = "WEB-INF/jsp/quDuan/quDuanQuery.jsp";
    private static final String toPlanAdminUrl = "WEB-INF/jsp/plan/planQuery.jsp";
    private static final String toDiaoDuAdminUrl = "WEB-INF/jsp/diaoDu/seatAnnounce.jsp";

    PlanService planService = new PlanService();
    DiaoduService diaoduService = new DiaoduService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String function = req.getParameter("function");
        HttpSession session = req.getSession();
        if ("station".equals(function)) {
            //跳转到车站管理模块
        } else if ("train".equals(function)) {
            //跳转到列车管理模块
        } else if ("line".equals(function)) {
            //跳转到线路管理模块
        } else if ("trainGrouped".equals(function)) {
            //跳转到列车编组管理模块
        } else if ("priceRate".equals(function)) {
            //跳转到票价率管理模块
        } else if ("quDuan".equals(function)) {
            //跳转到票价旅程区段管理模块
            req.getRequestDispatcher(toQuDuanAdminUrl).forward(req,resp);
        } else if ("diYuanDiJianLv".equals(function)) {
            //跳转到递远递减率管理模块
        } else if ("plan".equals(function)) {
            //跳转到计划管理模块
            req.getRequestDispatcher(toPlanAdminUrl).forward(req,resp);
        } else if ("announceSeat".equals(function)) {
            //跳转到调度模块，执行计划，发布席位
            int planid = Integer.parseInt(req.getParameter("planid"));
            Plan plan = planService.getPlanByPlanId(planid);
            planService.announceSeat(plan);
            List<Seat> seatList = diaoduService.getAllSeats();
            session.setAttribute("seatList",seatList);
            req.getRequestDispatcher(toDiaoDuAdminUrl).forward(req,resp);
        } else if ("diaodu".equals(function)) {
            //跳转到调度模块
            req.getRequestDispatcher(toDiaoDuAdminUrl).forward(req,resp);
        }

    }
}
