package com.csu.servlet.station;

import com.csu.domain.station.Station;
import com.csu.service.BaseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Asus_ on 2016/9/20.
 */
@WebServlet(name = "NewStationServlet",urlPatterns = {"/newStation"})
public class NewStationServlet extends HttpServlet {
    private static final String MANAGEMENT = "/WEB-INF/jsp/management/management.html";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        Station station = new Station();
        station.setStationName(request.getParameter("stationName"));
        station.setPinYin(request.getParameter("pinYin"));
        station.setLocation(request.getParameter("Location"));
        BaseService baseService = new BaseService();
        baseService.addStation(station);
        request.getRequestDispatcher(MANAGEMENT).forward(request,response);
    }
}
