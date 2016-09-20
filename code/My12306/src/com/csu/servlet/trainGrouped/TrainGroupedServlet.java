package com.csu.servlet.trainGrouped;

import com.csu.domain.diaoDu.Seat;
import com.csu.domain.trainGrouped.TrainGrouped;
import com.csu.service.BaseService;
import com.csu.service.DiaoduService;

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
 * Created by war on 2016/9/20.
 */
@WebServlet(name = "TrainGroupedServlet", urlPatterns = {"/trainGrouped"})
public class TrainGroupedServlet extends HttpServlet{
    private static String trainGroupedModifyUrl = "/WEB-INF/jsp/trainGrouped/trainGroupedModify.jsp";
    private static String trainGroupedQueryUrl = "/WEB-INF/jsp/trainGrouped/trainGroupedQuery.jsp";
    private static String trainGroupedAddUrl = "/WEB-INF/jsp/trainGrouped/trainGroupedAdd.jsp";
    BaseService baseService =new BaseService();
    DiaoduService diaoduService = new DiaoduService();
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
            boolean status = false;
            TrainGrouped trainGrouped =null;
            Seat seat =null;
            List<Seat> seats = new ArrayList<>();
            int trainId = Integer.parseInt(req.getParameter("trainId"));
            int chexiang = Integer.parseInt(req.getParameter("chexiang"));
            seats = diaoduService.getSeatsByTrainIdAndCheXiang(trainId,chexiang);
            for(int i=0;i<seats.size();i++){
                seat = seats.get(i);
                if(seat.getStatus().equals("已售")){
                    status = true;
                    break;
                }
            }
            if(status){
                String message = "删除失败";
                session.setAttribute("message",message);
                req.getRequestDispatcher(trainGroupedQueryUrl).forward(req,resp);
            }
            else{
                baseService.deleteTrainGroupBytrainIdAndCheXiang(trainId,chexiang);
                ArrayList<TrainGrouped> trainGroupeds = new ArrayList<>();
                trainGroupeds.add(trainGrouped);
                session.setAttribute("trainGroupeds",trainGroupeds);
                String message = "删除成功";
                session.setAttribute("message",message);
                req.getRequestDispatcher(trainGroupedQueryUrl).forward(req,resp);
            }
        }
        else if("add".equals(function)){
            req.getRequestDispatcher(trainGroupedAddUrl).forward(req,resp);
        }
    }
}
