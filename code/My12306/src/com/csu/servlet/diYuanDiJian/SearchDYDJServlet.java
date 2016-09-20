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
import java.util.List;

/**
 * Created by Asus_ on 2016/9/20.
 */
@WebServlet(name = "SearchDYDJServlet",urlPatterns = {"/searchDYDJ"})
public class SearchDYDJServlet extends HttpServlet {
    private static final String SEARCHDYDJ = "/WEB-INF/jsp/diYuanDiJianLv/searchRate.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        BaseService baseService = new BaseService();
        List<DiYuanDiJianLv>  diYuanDiJianLvs = baseService.getDYDJLvs();
        HttpSession session = request.getSession();
        session.setAttribute("diYuanDiJianLvs",diYuanDiJianLvs);
        request.getRequestDispatcher(SEARCHDYDJ).forward(request,response);
    }
}
