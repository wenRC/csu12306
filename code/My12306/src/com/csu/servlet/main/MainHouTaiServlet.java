package com.csu.servlet.main;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sx on 2016/9/17.
 */
@WebServlet(name = "MainHouTaiServlet",urlPatterns = {"/mainHouTai"})
public class MainHouTaiServlet extends HttpServlet {
    private static final String toBaseDataMainUrl = "WEB-INF/jsp/baseDataMain.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String role = req.getParameter("role");
        if ("baseDataAdmin".equals(role)) {
            req.getRequestDispatcher(toBaseDataMainUrl).forward(req,resp);
        } else if ("planAdmin".equals(role)) {

        } else if ("diaoDuAdmin".equals(role)) {

        }
    }
}
