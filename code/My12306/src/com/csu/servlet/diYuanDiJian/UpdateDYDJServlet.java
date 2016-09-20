package com.csu.servlet.diYuanDiJian;

import com.csu.domain.diYuanDiJianLv.DiYuanDiJianLv;
import com.csu.service.BaseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Asus_ on 2016/9/20.
 */
@WebServlet(name = "UpdateDYDJServlet",urlPatterns = {"/updateDYDJ"})
public class UpdateDYDJServlet extends HttpServlet {
    private static final String MANAGEMENT = "/WEB-INF/jsp/management/management.html";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        DiYuanDiJianLv diYuanDiJianLv = new DiYuanDiJianLv();
        diYuanDiJianLv.setdYDJId(Integer.parseInt(request.getParameter("dYDJId")));
        diYuanDiJianLv.setdYDJFrom(request.getParameter("dYDJFrom"));
        diYuanDiJianLv.setdYDJTo(request.getParameter("dYDJTo"));
        diYuanDiJianLv.setdYDJRate(Double.parseDouble(request.getParameter("dYDJRate")));
        diYuanDiJianLv.setPriceRate(Double.parseDouble(request.getParameter("priceRate")));
        BaseService baseService = new BaseService();
        baseService.updateDYDJLv(diYuanDiJianLv);
        request.getRequestDispatcher(MANAGEMENT).forward(request,response);
    }
}
