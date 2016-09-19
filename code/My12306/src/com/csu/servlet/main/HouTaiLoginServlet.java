package com.csu.servlet.main;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by sx on 2016/9/20.
 */
@WebServlet(name = "HouTaiLoginServlet",urlPatterns = {"/houtailogin"})
public class HouTaiLoginServlet extends HttpServlet{
    private static final String houTaiLoginUrl = "WEB-INF/jsp/houTaiLogin/houTaiLogin.jsp";
    private static final String toHouTaiUrl = "indexB.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adminName = req.getParameter("adminName");
        String adminPassword = req.getParameter("adminPassword");
        HttpSession session = req.getSession();
        if (!"admin".equals(adminName) || !"123".equals(adminPassword)) {
            req.getRequestDispatcher(houTaiLoginUrl).forward(req,resp);
        } else {
            session.setAttribute("adminName",adminName);
            session.setAttribute("adminPassword",adminPassword);
            req.getRequestDispatcher(toHouTaiUrl).forward(req,resp);
        }
    }
}
