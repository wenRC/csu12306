package com.csu.servlet.order;

import com.csu.domain.piaoWu.PiaoWu;
import com.csu.service.GetPiaoWuAndYuPIaoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/**
 * Created by 温 睿诚 on 2016/9/20/0020.
 */
@WebServlet(name = "SearchOrderByOrdetTimeServlet", urlPatterns = {"/searchOrderByTime"})
public class SearchOrderByOrdetTimeServlet extends HttpServlet {
    private static final String url = "/WEB-INF/jsp/order/searchOrder.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int select = Integer.parseInt(req.getParameter("select"));
        String date = req.getParameter("date");
        HttpSession session = req.getSession();
        ArrayList<PiaoWu> piaoWus = (ArrayList<PiaoWu>) session.getAttribute("piaowus");
        Iterator<PiaoWu> iterator = piaoWus.iterator();
        while (iterator.hasNext()) {
            PiaoWu piaoWu=iterator.next();
            //按订票日期
            if (select == 1) {
                Timestamp timestamp=piaoWu.getOrderTime();
                Date date1=timeStamp2Date(timestamp);
                String a= date1.toString();
                if (!a.equals(date)) {
                    iterator.remove();
                }
            }else{
                String a= timeStamp2Date(piaoWu.getDate()).toString();
                if (!a.equals(date)) {
                    iterator.remove();
                }
            }
        }
        session.setAttribute("piaowus",piaoWus);
        req.getRequestDispatcher(url).forward(req, resp);

    }
    private   Date timeStamp2Date(Timestamp timestamp){
        String temp=timestamp.toString();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        java.util.Date date=null;
        try {
            date= dateFormat.parse(temp);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("字符串转date失败");
        }
        return new Date(date.getTime());
    }
}
