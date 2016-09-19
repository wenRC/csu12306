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
@WebServlet(name = "HouTaiExitServlet",urlPatterns = {"/houtaiexit"})
public class HouTaiExitServlet extends HttpServlet {
    private static final String toQianTaiUrl = "index.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("adminName",null);
        session.setAttribute("adminPassowrd",null);
        req.getRequestDispatcher(toQianTaiUrl).forward(req,resp);
    }
}
