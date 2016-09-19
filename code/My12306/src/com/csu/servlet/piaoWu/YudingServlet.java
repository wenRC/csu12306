package com.csu.servlet.piaoWu;

import com.csu.domain.order.YuPiao;
import com.csu.domain.piaoWu.PiaoWu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 温 睿诚 on 2016/9/19/0019.
 */
@WebServlet(name = "YudingServlet",urlPatterns = {"/yuding"})
public class YudingServlet extends HttpServlet {
    private static final String url = "/WEB-INF/jsp/order/confirm.jsp";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int index=Integer.parseInt(req.getParameter("index"));
        HttpSession session=req.getSession();
        ArrayList<YuPiao> yuPiaos= (ArrayList<YuPiao>) session.getAttribute("yupiaos");
        session.setAttribute("piao",yuPiaos.get(index));
        req.getRequestDispatcher(url).forward(req,resp);

    }
}
