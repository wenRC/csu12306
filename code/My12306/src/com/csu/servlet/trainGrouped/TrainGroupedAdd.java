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
@WebServlet(name = "TrainGroupedAdd",urlPatterns = {"/trainGroupedAdd"})
public class TrainGroupedAdd extends HttpServlet {
    private static String trainGroupedQueryUrl = "/WEB-INF/jsp/trainGrouped/trainGroupedQuery.jsp";
    private static String getTrainGroupedAddUrl = "/WEB-INF/jsp/trainGrouped/trainGroupedAdd.jsp";
    BaseService baseService = new BaseService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        TrainGrouped trainGrouped = null;
        TrainGrouped trainGrouped1 = null;
        ArrayList<TrainGrouped> trainGroupeds= new ArrayList<>();
        int trainGroupedId = Integer.parseInt(req.getParameter("trainGroupedId"));
        trainGrouped1 = baseService.getTrainGroupBytrainGroupedId(trainGroupedId);
        if(trainGrouped1==null){
            int trainId = Integer.parseInt(req.getParameter("trainId"));
            int chexiang = Integer.parseInt(req.getParameter("chexiang"));
            String seatType = req.getParameter("seatType");
            int seatNumber = Integer.parseInt(req.getParameter("seatNumber"));
            String chexiangType = req.getParameter("chexiangType");
            trainGrouped = new TrainGrouped(trainGroupedId,trainId,chexiang,seatType,seatNumber,chexiangType);
            baseService.insertTrainGroup(trainGrouped);
            trainGroupeds.add(trainGrouped);
            String message ="添加成功";
            session.setAttribute("message",message);
            session.setAttribute("trainGroupeds",trainGroupeds);
            req.getRequestDispatcher(trainGroupedQueryUrl).forward(req,resp);
        }
       else {
            String message ="添加失败，列车编组编号已存在";
            session.setAttribute("message",message);
            session.setAttribute("trainGrouped",trainGrouped);
            req.getRequestDispatcher(getTrainGroupedAddUrl).forward(req,resp);
        }
    }
}
