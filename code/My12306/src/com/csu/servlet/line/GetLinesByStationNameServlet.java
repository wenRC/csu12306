package com.csu.servlet.line;

import com.csu.domain.line.Line;
import com.csu.service.BaseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Asus_ on 2016/9/20.
 */
@WebServlet(name = "GetLinesByStationNameServlet",urlPatterns = {"/getByStationName"})
public class GetLinesByStationNameServlet extends HttpServlet {
    private static final String GETBYSTATIONNAME = "/WEB-INF/jsp/line/searchLineByStationResult.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        BaseService baseService = new BaseService();
        List<Line> lines = baseService.searchLineByStationName(request.getParameter("stationName"));
        HttpSession session = request.getSession();
        session.setAttribute("lines",lines);
        request.getRequestDispatcher(GETBYSTATIONNAME).forward(request,response);
    }
}
