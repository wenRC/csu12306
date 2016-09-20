package com.csu.servlet.line;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Asus_ on 2016/9/20.
 */
@WebServlet(name = "SearchByStationNameServlet",urlPatterns = {"/searchByStationName"})
public class SearchByStationNameServlet extends HttpServlet {
    private static final String SEARCHBYSTATIONNAME = "/WEB-INF/jsp/line/searchLineByStation.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher(SEARCHBYSTATIONNAME).forward(request,response);
    }
}
