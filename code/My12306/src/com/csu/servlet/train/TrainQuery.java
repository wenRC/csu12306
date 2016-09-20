package com.csu.servlet.train;

import com.csu.domain.train.Train;
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
 * Created by war on 2016/9/19.
 */
@WebServlet(name = "TrainQuery", urlPatterns = {"/trainQuery"})
public class TrainQuery extends HttpServlet {
    private static String trainQueryUrl = "/WEB-INF/jsp/train/trainQuery.jsp";
    BaseService baseService = new BaseService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        Train train = null;
        ArrayList<Train> trains= new ArrayList<>();
        int trainId = Integer.parseInt(req.getParameter("trainId"));
        train = baseService.getTrainBytrainId(trainId);
        trains.add(train);
        session.setAttribute("trains",trains);
        req.getRequestDispatcher(trainQueryUrl).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
