package com.csu.servlet.piaoWu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 温 睿诚 on 2016/9/19/0019.
 */
@WebServlet(name = "ForwardServlet",urlPatterns = {"/forward"})
public class ForwardServlet extends HttpServlet{
    private static final String qupiao="/WEB-INF/jsp/piaoWu/qupiao.jsp";
    private static final String searchOrder="/WEB-INF/jsp/order/searchOrder.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String para=req.getParameter("to");
        String url;
        switch (para){
            case "qupiao":
                url=qupiao;
                break;
            default:
                url=searchOrder;
                break;
        }
        req.getRequestDispatcher(url).forward(req,resp);
    }
}
