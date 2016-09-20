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
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Created by war on 2016/9/19.
 */
@WebServlet(name = "TrainModify", urlPatterns = {"/trainModify"})
public class TrainModify extends HttpServlet{
    private static String trainQueryUrl = "/WEB-INF/jsp/train/trainQuery.jsp";
    BaseService baseService = new BaseService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        int trainId = Integer.parseInt(req.getParameter("trainId"));
        String from = req.getParameter("from");
        String to = req.getParameter("to");
        Timestamp fromTime = Timestamp.valueOf(req.getParameter("fromTime"));
        Timestamp toTime =Timestamp.valueOf(req.getParameter("toTime"));
        String last = req.getParameter("last");
        int distance = Integer.parseInt(req.getParameter("distance"));
        int noseatnumber = Integer.parseInt(req.getParameter("noseatnumber"));
        String type = req.getParameter("type");
        Train train = new Train(trainId,from,to,fromTime,toTime,last,distance,noseatnumber,type);
        baseService.updateTrain(train);
        ArrayList<Train> trains = new ArrayList<>();
        trains.add(train);
        session.setAttribute("trains",trains);
        req.getRequestDispatcher(trainQueryUrl).forward(req,resp);
    }
}
