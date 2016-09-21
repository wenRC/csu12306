package com.csu.servlet.main;

import com.csu.domain.diaoDu.Seat;
import com.csu.domain.plan.Plan;
import com.csu.domain.priceRate.PriceRate;
import com.csu.domain.train.Train;
import com.csu.domain.trainGrouped.TrainGrouped;
import com.csu.service.BaseService;
import com.csu.service.DiaoduService;
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
@WebServlet(name = "ToServlet", urlPatterns = {"/to"})
public class ToServlet extends HttpServlet {
    private static final String toQuDuanAdminUrl = "WEB-INF/jsp/quDuan/quDuanQuery.jsp";
    private static final String toPlanAdminUrl = "WEB-INF/jsp/plan/planQuery.jsp";
    private static final String toDiaoDuAdminUrl = "WEB-INF/jsp/diaoDu/seatAnnounce.jsp";
    private static final String toHouTaiUrl = "indexB.jsp";
    private static final String toTrainAdminUrl = "WEB-INF/jsp/train/trainQuery.jsp";
    private static final String toTrainGroupedAdminUrl = "WEB-INF/jsp/trainGrouped/trainGroupedQuery.jsp";
    private static final String toPriceRateAdminUrl = "/WEB-INF/jsp/priceRate/priceRateQuery.jsp";
    PlanService planService = new PlanService();
    DiaoduService diaoduService = new DiaoduService();
    BaseService baseService =new BaseService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String function = req.getParameter("function");
        HttpSession session = req.getSession();
        if ("toHouTai".equals(function)) {
            //跳转到后台主页
            req.getRequestDispatcher(toHouTaiUrl).forward(req,resp);
        } else if ("station".equals(function)) {
            //跳转到车站管理模块
        } else if ("train".equals(function)) {
            //跳转到列车管理模块
            ArrayList<Train> trains = new ArrayList<>();
            List<Train> trains1 = new ArrayList<>();
            session.setAttribute("trains",trains);
            trains1 = baseService.getAllTrains();
            session.setAttribute("trains1",trains1);
            req.getRequestDispatcher(toTrainAdminUrl).forward(req,resp);
        } else if ("line".equals(function)) {
            //跳转到线路管理模块
        } else if ("trainGrouped".equals(function)) {
            //跳转到列车编组管理模块
            ArrayList<TrainGrouped> trainGroupeds = new ArrayList<>();
            session.setAttribute("trainGroupeds",trainGroupeds);
            ArrayList<TrainGrouped> trainGroupeds1 = new ArrayList<>();
            trainGroupeds1 = baseService.getAllTrainGroups();
            session.setAttribute("trainGroupeds1",trainGroupeds1);
            req.getRequestDispatcher(toTrainGroupedAdminUrl).forward(req,resp);
        } else if ("priceRate".equals(function)) {
            //跳转到票价率管理模块
            ArrayList<PriceRate> priceRates = new ArrayList<>();
            session.setAttribute("priceRates",priceRates);
            ArrayList<PriceRate> priceRates1 = new ArrayList<>();
            priceRates1 = baseService.getAllPriceRate();
            session.setAttribute("priceRates1",priceRates1);
            req.getRequestDispatcher(toPriceRateAdminUrl).forward(req,resp);
        } else if ("quDuan".equals(function)) {
            //跳转到票价旅程区段管理模块
            req.getRequestDispatcher(toQuDuanAdminUrl).forward(req, resp);
        } else if ("diYuanDiJianLv".equals(function)) {
            //跳转到递远递减率管理模块
        } else if ("plan".equals(function)) {
            //跳转到计划管理模块
            req.getRequestDispatcher(toPlanAdminUrl).forward(req, resp);
        } else if ("announceSeat".equals(function)) {
            //跳转到调度模块，执行计划，发布席位
            int planid = Integer.parseInt(req.getParameter("planid"));
            Plan plan = planService.getPlanByPlanId(planid);
            planService.announceSeat(plan);
            List<Seat> seatList = diaoduService.getAllSeats();
            session.setAttribute("seatList", seatList);
            req.getRequestDispatcher(toDiaoDuAdminUrl).forward(req, resp);
        } else if ("diaodu".equals(function)) {
            //跳转到调度模块
            req.getRequestDispatcher(toDiaoDuAdminUrl).forward(req, resp);
        }

    }
}
