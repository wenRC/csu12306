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
@WebServlet(name = "TrainGroupedQuery",urlPatterns = {"/trainGroupedQuery"})
public class TrainGroupedQuery  extends HttpServlet{
    private static String trainGroupedQueryUrl = "/WEB-INF/jsp/trainGrouped/trainGroupedQuery.jsp";
    BaseService baseService = new BaseService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        TrainGrouped trainGrouped = null;
        ArrayList<TrainGrouped> trainGroupeds = new ArrayList<>();
        int trainId = Integer.parseInt(req.getParameter("trainId"));
        int chexiang = Integer.parseInt(req.getParameter("chexiang"));
        trainGrouped = baseService.getTrainGroupBytrainIdAndCheXiang(trainId,chexiang);
        trainGroupeds.add(trainGrouped);
        session.setAttribute("trainGroupeds",trainGroupeds);
        req.getRequestDispatcher(trainGroupedQueryUrl).forward(req,resp);
    }
}
