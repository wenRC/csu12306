package com.csu.servlet.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 温 睿诚 on 2016/9/15/0015.
 */
@WebServlet(name = "ViewChangeUserInfoServlet",urlPatterns = {"/ViewChangeUserInfo"})
public class ViewChangeUserInfoServlet extends HttpServlet {
    private static final String url="/WEB-INF/jsp/user/changeUserInfo.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(url).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
