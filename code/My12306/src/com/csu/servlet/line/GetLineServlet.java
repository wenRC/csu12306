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

/**
 * Created by Asus_ on 2016/9/20.
 */
@WebServlet(name = "GetLineServlet",urlPatterns = {"/getLine"})
public class GetLineServlet extends HttpServlet {
    private static final String GETLINE = "/WEB-INF/jsp/line/line.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        BaseService baseService = new BaseService();
        Line line = baseService.getLineByLineId(Integer.parseInt(request.getParameter("lineId")));
        HttpSession session = request.getSession();
        session.setAttribute("line",line);
        request.getRequestDispatcher(GETLINE).forward(request,response);
    }
}
