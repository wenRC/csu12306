package com.csu.servlet.main;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sx on 2016/9/18.
 */
@WebServlet(name = "ToServlet",urlPatterns = {"/to"})
public class ToServlet extends HttpServlet {
    private static final String toQuDuanAdminUrl = "WEB-INF/jsp/quDuan/quDuanQuery.jsp";
    private static final String toPlanAdminUrl = "WEB-INF/jsp/plan/planQuery.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String function = req.getParameter("function");
        if ("station".equals(function)) {
            //跳转到车站管理模块
        } else if ("train".equals(function)) {
            //跳转到列车管理模块
        } else if ("line".equals(function)) {
            //跳转到线路管理模块
        } else if ("trainGrouped".equals(function)) {
            //跳转到列车编组管理模块
        } else if ("priceRate".equals(function)) {
            //跳转到票价率管理模块
        } else if ("quDuan".equals(function)) {
            //跳转到票价旅程区段管理模块
            req.getRequestDispatcher(toQuDuanAdminUrl).forward(req,resp);
        } else if ("diYuanDiJianLv".equals(function)) {
            //跳转到递远递减率管理模块
        } else if ("plan".equals(function)) {
            //跳转到计划管理模块
            req.getRequestDispatcher(toPlanAdminUrl).forward(req,resp);
        }
    }
}
