package com.csu.servlet.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 温 睿诚 on 2016/9/18/0018.
 */
@WebServlet(name = "ViewReg",urlPatterns = {"/ViewReg"})
public class ViewRegServlet extends HttpServlet {
    private static final String url="/WEB-INF/jsp/user/reg.jsp";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        session.setAttribute("regmsg","注册新用户");
        req.getRequestDispatcher(url).forward(req,resp);
    }
}
