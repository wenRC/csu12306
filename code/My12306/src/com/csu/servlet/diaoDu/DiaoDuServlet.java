package com.csu.servlet.diaoDu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sx on 2016/9/19.
 */
@WebServlet(name = "DiaoDuServlet",urlPatterns = {"/diaodu"})
public class DiaoDuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String function = req.getParameter("function");
        if ("query".equals(function)) {
            //按车次、车厢进行席位查询
        } else if ("queryAll".equals(function)) {
            //显示所有席位信息
        } else if ("modify".equals(function)) {
            //修改席位信息
        } else if ("seatCount".equals(function)) {
            //进行客运统计
        }

    }
}
