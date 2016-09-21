package com.csu.servlet.piaoWu;

import com.csu.domain.order.YuPiao;
import com.csu.service.GetPiaoWuAndYuPIaoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by 温 睿诚 on 2016/9/19/0019.
 */
@WebServlet(name = "SearchPiao",urlPatterns = {"/searchPiao"})
public class SearchPiao extends HttpServlet {
    private static final String url="/WEB-INF/jsp/order/yupiao.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String from=req.getParameter("fromplace");
        String to=req.getParameter("toplace");
        String date=req.getParameterMap().get("date")[0];
        ArrayList<YuPiao> yuPiaos=new GetPiaoWuAndYuPIaoService().getYuPiaoByStationName(from,to);
        if(!(date==null||date.equals(""))){
        Iterator<YuPiao> iterator=yuPiaos.iterator();
        while (iterator.hasNext()){
            String temp=iterator.next().getDate().toString();
            if(!temp.equals(date)){
                iterator.remove();
            }
        }}
        HttpSession session=req.getSession();
        session.setAttribute("yupiaos",yuPiaos);
        req.getRequestDispatcher(url).forward(req,resp);

    }
}
