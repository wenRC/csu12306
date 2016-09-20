package com.csu.servlet.trainGrouped;

import com.csu.domain.trainGrouped.TrainGrouped;
import com.csu.service.BaseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by war on 2016/9/20.
 */
@WebServlet(name = "TrainGroupedServlet", urlPatterns = {"/trainGrouped"})
public class TrainGroupedServlet extends HttpServlet{
    private static String trainGroupedModifyUrl = "/WEB-INF/jsp/trainGrouped/trainGroupedModify.jsp";
    private static String trainGroupedQueryUrl = "/WEB-INF/jsp/trainGrouped/trainGroupedQuery.jsp";
    private static String trainGroupedAddUrl = "/WEB-INF/jsp/trainGrouped/trainGroupedAdd.jsp";
    BaseService baseService =new BaseService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        String function = req.getParameter("function");
        if ("modify".equals(function)) {
            TrainGrouped trainGrouped = null;
            int trainId = Integer.parseInt(req.getParameter("trainId"));
            int chexiang = Integer.parseInt(req.getParameter("chexiang"));
            trainGrouped = baseService.getTrainGroupBytrainIdAndCheXiang(trainId,chexiang);
            session.setAttribute("trainGrouped",trainGrouped);
            req.getRequestDispatcher(trainGroupedModifyUrl).forward(req, resp);
        }
        else if("delete".equals(function)){
            TrainGrouped trainGrouped =null;
            int trainId = Integer.parseInt(req.getParameter("trainId"));
            int chexiang = Integer.parseInt(req.getParameter("chexiang"));
            baseService.deleteTrainGroupBytrainIdAndCheXiang(trainId,chexiang);
            ArrayList<TrainGrouped> trainGroupeds = new ArrayList<>();
            trainGroupeds.add(trainGrouped);
            session.setAttribute("trainGroupeds",trainGroupeds);
            req.getRequestDispatcher(trainGroupedQueryUrl).forward(req,resp);
        }
        else if("add".equals(function)){
            req.getRequestDispatcher(trainGroupedAddUrl).forward(req,resp);
        }
    }
}
