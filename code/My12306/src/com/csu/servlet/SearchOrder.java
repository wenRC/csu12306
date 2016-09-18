package com.csu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by 温 睿诚 on 2016/9/18/0018.
 */
@WebServlet(name = "SearchOrder",urlPatterns = {"/searchOrder"})
public class SearchOrder extends HttpServlet {
    private static final String url="/WEB-INF/jsp/order/searchOrder.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String date=req.getParameter("date");

        System.out.println(date);
    }
}
