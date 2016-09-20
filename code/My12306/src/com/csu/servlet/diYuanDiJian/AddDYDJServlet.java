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
@WebServlet(name = "AddDYDJServlet",urlPatterns = {"/newDYDJ"})
public class AddDYDJServlet extends HttpServlet {
    private static final String MANAGEMENT = "/indexB.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        DiYuanDiJianLv diYuanDiJianLv = new DiYuanDiJianLv();
        diYuanDiJianLv.setPriceRate(Double.parseDouble(request.getParameter("priceRate")));
        diYuanDiJianLv.setdYDJRate(Double.parseDouble(request.getParameter("rate")));
        diYuanDiJianLv.setdYDJTo(request.getParameter("to"));
        diYuanDiJianLv.setdYDJFrom(request.getParameter("from"));
//        System.out.println(diYuanDiJianLv.getdYDJFrom());
//        System.out.println(diYuanDiJianLv.getdYDJTo());
//        System.out.println(diYuanDiJianLv.getdYDJRate());
//        System.out.println(diYuanDiJianLv.getPriceRate());
        BaseService baseService = new BaseService();
        baseService.addDYDJLv(diYuanDiJianLv);
        request.getRequestDispatcher(MANAGEMENT).forward(request,response);
    }
}
