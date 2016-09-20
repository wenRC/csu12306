package com.csu.servlet.diYuanDiJian;

import com.csu.domain.diYuanDiJianLv.DiYuanDiJianLv;
import com.csu.service.BaseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Asus_ on 2016/9/20.
 */
@WebServlet(name = "DYDJServlet",urlPatterns = {"/dYDJ"})
public class DYDJServlet extends HttpServlet {
    private static final String DYDJ = "/WEB-INF/jsp/diYuanDiJianLv/rate.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String s = request.getParameter("dYDJId");
        BaseService baseService = new BaseService();
        DiYuanDiJianLv diYuanDiJianLv = baseService.getDYDJLvByDYDJLID(Integer.parseInt(s));
        HttpSession session = request.getSession();
        session.setAttribute("dYDJ",diYuanDiJianLv);
        request.getRequestDispatcher(DYDJ).forward(request,response);
    }
}
