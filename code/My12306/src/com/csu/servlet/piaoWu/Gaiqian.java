package com.csu.servlet.piaoWu;

import com.csu.domain.order.YuPiao;
import com.csu.domain.piaoWu.PiaoWu;
import com.csu.service.GetPiaoWuAndYuPIaoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 温 睿诚 on 2016/9/20/0020.
 */
@WebServlet(name = "Gaiqian",urlPatterns = {"/gaiqian"})
public class Gaiqian extends HttpServlet{
    private static final String url="/WEB-INF/jsp/piaoWu/gaiqian.jsp";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int index=Integer.parseInt(req.getParameter("index"));
        HttpSession session=req.getSession();
        ArrayList<PiaoWu> piaoWus= (ArrayList<PiaoWu>) session.getAttribute("piaowus");
        PiaoWu piaoWu=piaoWus.get(index);
        String from=piaoWu.getFrom();
        String to=piaoWu.getTo();
        int trainId=piaoWu.getTrainId();
        ArrayList<YuPiao> yuPiaos=new GetPiaoWuAndYuPIaoService().getYuPiaoByStationName(from,to);
        session.setAttribute("piao",piaoWu);
        session.setAttribute("yupiaos",yuPiaos);
        session.setAttribute("from",from);
        session.setAttribute("to",to);
        session.setAttribute("trainId",trainId);
        req.getRequestDispatcher(url).forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
