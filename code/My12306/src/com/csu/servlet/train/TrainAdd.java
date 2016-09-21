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
@WebServlet(name = "TrainAdd", urlPatterns = {"/trainAdd"})
public class TrainAdd extends HttpServlet{
    private static String trainQueryUrl ="/WEB-INF/jsp/train/trainQuery.jsp";
    private static String trainAddUrl ="/WEB-INF/jsp/train/trainAdd.jsp";
    BaseService baseService =new BaseService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        int trainId = Integer.parseInt(req.getParameter("trainId"));
        Train train1 = baseService.getTrainBytrainId(trainId);
        if(train1==null){
            String form = req.getParameter("from");
            String to = req.getParameter("to");
            Timestamp fromTime = Timestamp.valueOf(req.getParameter("fromTime"));
            Timestamp toTime = Timestamp.valueOf(req.getParameter("toTime"));
            String last = req.getParameter("last");
            int distance = Integer.parseInt(req.getParameter("distance"));
            int noseatnumber = Integer.parseInt(req.getParameter("noseatnumber"));
            String type = req.getParameter("type");
            ArrayList<Train> trains = new ArrayList<>();
            Train train =new Train(trainId,form,to,fromTime,toTime,last,distance,noseatnumber,type);
            trains.add(train);
            String message ="添加成功";
            session.setAttribute("message",message);
            session.setAttribute("trains",trains);
            baseService.insertTrain(train);
            req.getRequestDispatcher(trainQueryUrl).forward(req,resp);
        }
        else {
            String message ="添加失败，车次代码已存在";
            session.setAttribute("message",message);
            session.setAttribute("train","");
            req.getRequestDispatcher(trainAddUrl).forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
