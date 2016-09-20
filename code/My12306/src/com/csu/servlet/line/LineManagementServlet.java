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
@WebServlet(name = "LineManagementServlet",urlPatterns = {"/lineManagement"})
public class LineManagementServlet extends HttpServlet {
    private static final String LINEMANAGEMENT = "/WEB-INF/jsp/line/lineManagement.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher(LINEMANAGEMENT).forward(request,response);
    }
}
