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
@WebServlet(name = "ViewChangeUserPass",urlPatterns = {"/ViewChangeUserPass"})
public class ViewChangeUserPassServlet extends HttpServlet{
    private static final String url="/WEB-INF/jsp/user/changePass.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        session.setAttribute("cupmsg","修改用户密码");
        req.getRequestDispatcher(url).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
