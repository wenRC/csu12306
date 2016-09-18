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
 * Created by 温 睿诚 on 2016/9/18/0018.
 */
@WebServlet(name = "UpdateUserServlet",urlPatterns = {"/updateUser"})
public class UpdateUserServlet extends HttpServlet {
    private static final String url="/WEB-INF/jsp/user/changeUserInfo.jsp";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        Map<String,String[]> stringObjectMap = req.getParameterMap();
        String email=stringObjectMap.get("email")[0];
        String sex=stringObjectMap.get("sex")[0].equals("1")?"男":"女";
        String username=stringObjectMap.get("username")[0];
        String id=stringObjectMap.get("id")[0];
        String phone=stringObjectMap.get("phone")[0];
        HttpSession session=req.getSession();
        User user= (User) session.getAttribute("user");
        user.setEmail(email);
        user.setSex(sex);
        user.setUsername(username);
        user.setId(id);
        user.setPhone(phone);
        UserService userService=new UserService();
        userService.updateUser(user);
        session.setAttribute("user",user);
        session.setAttribute("cumsg","修改成功");
        req.getRequestDispatcher(url).forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
