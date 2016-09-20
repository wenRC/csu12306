package com.csu.servlet.line;

import com.csu.domain.line.Line;
import com.csu.service.BaseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

/**
 * Created by Asus_ on 2016/9/20.
 */
@WebServlet(name = "UpdateLineServlet",urlPatterns = {"/updateLine"})
public class UpdateLineServlet extends HttpServlet {
    private static final String UPDATELINE = "/indexB.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        BaseService baseService = new BaseService();
        Line line = new Line();
        line.setLineId(Integer.parseInt(request.getParameter("lineId")));
        line.setTrainId(Integer.parseInt(request.getParameter("trainId")));
        line.setStationName(request.getParameter("stationName"));
        line.setFromTime(request.getParameter("fromTime"));
        line.setLastTime(request.getParameter("lastTime"));
        line.setDistance(Integer.parseInt(request.getParameter("distance")));
        baseService.updateLine(line);
        request.getRequestDispatcher(UPDATELINE).forward(request,response);
    }
}
