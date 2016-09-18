package com.csu.servlet.user;

import com.csu.domain.user.User;
import com.csu.service.UserService;

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
@WebServlet(name = "changePassword",urlPatterns = {"/changePassword"})
public class ChangePasswordServlet extends HttpServlet {
    private static final String url="/WEB-INF/jsp/user/changePass.jsp";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password=req.getParameter("password");
        String confirm=req.getParameter("confirmPassword");
        HttpSession session=req.getSession();
        if(password==null||confirm==null||password.equals("")){
            session.setAttribute("cupmsg","密码不能为空");
            req.getRequestDispatcher(url).forward(req,resp);
        }
        else if(!password.equals(confirm)){
            session.setAttribute("cupmsg","新密码与确认密码不一致");
            req.getRequestDispatcher(url).forward(req,resp);
        }else{
            User user= (User) session.getAttribute("user");
            user.setPassword(password);
            UserService userService=new UserService();
            userService.updateUser(user);
            session.setAttribute("cupmsg","修改成功");
            req.getRequestDispatcher(url).forward(req,resp);
        }
    }
}
