package com.csu.servlet.user;

import com.csu.domain.user.User;
import com.csu.service.UserService;
import com.csu.servlet.MakeId;

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
@WebServlet(name = "reg",urlPatterns = {"/reg"})
public class RegServlet extends HttpServlet {
    private static final String errorurl="/WEB-INF/jsp/user/reg.jsp";
    private static final String succurl="/index.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String password=req.getParameter("password");
        String confirm=req.getParameter("confirmPassword");
        HttpSession session=req.getSession();
        if(password==null||confirm==null||password.equals("")){
            session.setAttribute("regmsg","密码不能为空");
            req.getRequestDispatcher(errorurl).forward(req,resp);
        }
        else if(!password.equals(confirm)){
            session.setAttribute("regmsg","密码与确认密码不一致");
            req.getRequestDispatcher(errorurl).forward(req,resp);
        }else{
            Map<String,String[]> stringObjectMap = req.getParameterMap();
            String email=stringObjectMap.get("email")[0];
            String sex=stringObjectMap.get("sex")[0].equals("1")?"男":"女";
            String username=stringObjectMap.get("username")[0];
            String id=stringObjectMap.get("id")[0];
            String phone=stringObjectMap.get("phone")[0];
            User user=new User();
            user.setUserid(MakeId.getUserId(email));
            user.setEmail(email);
            user.setSex(sex);
            user.setUsername(username);
            user.setId(id);
            user.setPhone(phone);
            user.setPassword(password);
            UserService userService=new UserService();
            userService.insertUser(user);
            session.setAttribute("user",user);
            session.setAttribute("regmsg","注册成功");
            req.getRequestDispatcher(succurl).forward(req,resp);
        }
    }
}
