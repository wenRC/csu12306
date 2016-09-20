package com.csu.servlet.station;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Asus_ on 2016/9/20.
 */
@WebServlet(name = "SearchStationServlet",urlPatterns = {"/searchStation"})
public class SearchStationServlet extends HttpServlet {
    private static final String SEARCHSTATION = "/WEB-INF/jsp/station/searchStation.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher(SEARCHSTATION).forward(request,response);
    }
}
