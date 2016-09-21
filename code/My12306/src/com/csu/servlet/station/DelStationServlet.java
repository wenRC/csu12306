package com.csu.servlet.station;

import com.csu.service.BaseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Asus_ on 2016/9/21.
 */
@WebServlet(name = "DelStationServlet",urlPatterns = "/delStation")
public class DelStationServlet extends HttpServlet {
    private static final String INITIAL = "/indexB.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        BaseService baseService = new BaseService();
        baseService.delStation(Integer.parseInt(request.getParameter("stationId")));
        request.getRequestDispatcher(INITIAL).forward(request,response);
    }
}
