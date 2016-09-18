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
import java.util.Map;

/**
 * Created by 温 睿诚 on 2016/9/14/0014.
 */
@WebServlet(name = "LoginServlet",urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    private static final String succurl="/WEB-INF/jsp/order/yupiao.jsp";
    private static final String errorurl="/WEB-INF/jsp/user/login.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String,String[]> temp=request.getParameterMap();
        String email=temp.get("email")[0];
        String password=temp.get("password")[0];
        UserService userService=new UserService();
        User user=userService.getUserByEmailAndPassword(email,password);
        if(user!=null){

            request.getSession().setAttribute("user",user);
            request.getRequestDispatcher(succurl).forward(request,response);
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("logmsg", "邮箱或密码错误");
            request.getRequestDispatcher(errorurl).forward(request,response);
        }

    }
}
