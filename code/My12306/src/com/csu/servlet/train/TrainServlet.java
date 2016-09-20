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
@WebServlet(name = "TrainServlet", urlPatterns = {"/train"})
public class TrainServlet extends HttpServlet{
    private static String trainAddUrl = "/WEB-INF/jsp/train/trainAdd.jsp" ;
    private static String trainModifyUrl = "/WEB-INF/jsp/train/trainModify.jsp";
    private static String trainQueryUrl = "/WEB-INF/jsp/train/trainQuery.jsp";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String function = req.getParameter("function");
        BaseService baseService = new BaseService();
        HttpSession session = req.getSession();
        Train train = null;
        if("add".equals(function)){
            //跳到新增列车页面
            req.getRequestDispatcher(trainAddUrl).forward(req,resp);
        }
        else if("modify".equals(function)){
            //跳到修改列车页面
            int trainId = Integer.parseInt(req.getParameter("trainId"));
            train = baseService.getTrainBytrainId(trainId);
            session.setAttribute("train",train);
            req.getRequestDispatcher(trainModifyUrl).forward(req,resp);
        }
        else if("delete".equals(function)){
            //删除列车
            int trainId = Integer.parseInt(req.getParameter("trainId"));
            baseService.deleteTrainBytrainId(trainId);
            ArrayList<Train> trains = new ArrayList<>();
            trains.add(train);
            session.setAttribute("trains",trains);
            req.getRequestDispatcher(trainQueryUrl).forward(req,resp);
        }
    }
}
