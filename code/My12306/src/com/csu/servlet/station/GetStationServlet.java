package com.csu.servlet.station;

import com.csu.domain.station.Station;
import com.csu.service.BaseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Asus_ on 2016/9/20.
 */
@WebServlet(name = "GetStationServlet",urlPatterns = {"/getStation"})
public class GetStationServlet extends HttpServlet {
    private static final String STATION = "/WEB-INF/jsp/station/station.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String s = request.getParameter("stationName");
        BaseService baseService = new BaseService();
        Station station;
        if(baseService.getStationByStationName(s) != null){
            station = baseService.getStationByStationName(s);
        }else {
            station = baseService.getStationByPinYin(s);
        }
        HttpSession session = request.getSession();
        session.setAttribute("station",station);
        request.getRequestDispatcher(STATION).forward(request,response);
    }
}
