package com.csu.servlet.diYuanDiJian;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Asus_ on 2016/9/20.
 */
@WebServlet(name = "AddServlet",urlPatterns = {"/addDYDJ"})
public class AddServlet extends HttpServlet {
    private static final String ADDDYDJ = "/WEB-INF/jsp/diYuanDiJianLv/addRate.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher(ADDDYDJ).forward(request,response);
    }
}
