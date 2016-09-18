package com.csu.servlet.quDuan;

import com.csu.domain.quDuan.QuDuan;
import com.csu.service.BaseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sx on 2016/9/17.
 */
@WebServlet(name = "QuDuanServlet", urlPatterns = {"/quDuan"})
public class QuDuanServlet extends HttpServlet {
    private static final String quDuanQueryUrl = "WEB-INF/jsp/quDuan/quDuanQuery.jsp";
    private static final String quDuanModifyUrl = "WEB-INF/jsp/quDuan/quDuanModify.jsp";
    BaseService baseService = new BaseService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");//不加修改数据库时会乱码
        String function = req.getParameter("function");
        HttpSession session = req.getSession();
        List<QuDuan> quDuanList = new ArrayList<QuDuan>();
        QuDuan quDuan = null;
        if ("queryById".equals(function)) {
            //根据id查询
            int quDuanId = Integer.parseInt(req.getParameter("quDuanId"));
            quDuan = baseService.getQuDuanById(quDuanId);
            quDuanList.add(quDuan);
            session.setAttribute("quDuanList", quDuanList);
            req.getRequestDispatcher(quDuanQueryUrl).forward(req, resp);
        } else if ("queryAll".equals(function)) {
            //查询所有
            quDuanList = baseService.getAllQuDuans();
            session.setAttribute("quDuanList", quDuanList);
            req.getRequestDispatcher(quDuanQueryUrl).forward(req, resp);
        } else if ("toModify".equals(function)) {
            //修改
            int quDuanId = Integer.parseInt(req.getParameter("id"));
            quDuan = baseService.getQuDuanById(quDuanId);
            session.setAttribute("quDuan", quDuan);
            req.getRequestDispatcher(quDuanModifyUrl).forward(req, resp);
        } else if ("submitModify".equals(function)) {
            //提交修改
            int quDuanId = Integer.parseInt(req.getParameter("quDuanId"));
            String from = req.getParameter("from");
            String to = req.getParameter("to");
            int distancePerQD = Integer.parseInt(req.getParameter("distancePerQD"));
            int qdNumber = Integer.parseInt(req.getParameter("qdNumber"));
            quDuan = new QuDuan(quDuanId,from,to,distancePerQD,qdNumber);
            boolean flag = baseService.updateQuDuan(quDuan);
            quDuanList.add(quDuan);
            session.setAttribute("quDuanList", quDuanList);
            req.getRequestDispatcher(quDuanQueryUrl).forward(req, resp);
        }
    }
}
