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
@WebServlet(name = "FrontToBackServlet",urlPatterns = {"/toHouTai"})
public class FrontToBackServlet extends HttpServlet {
    private static final String toHouTaiurl = "WEB-INF/jsp/mainHouTai.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(toHouTaiurl).forward(req,resp);
    }
}
