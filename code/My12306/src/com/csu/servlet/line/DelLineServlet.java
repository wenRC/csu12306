package com.csu.servlet.line;

import com.csu.service.BaseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Asus_ on 2016/9/21.
 */
@WebServlet(name = "DelLineServlet",urlPatterns = {"/delLine"})
public class DelLineServlet extends HttpServlet {
    private static final String INITIAL = "/indexB.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        BaseService baseService = new BaseService();
        baseService.delLineByLineId(Integer.parseInt(request.getParameter("lineId")));
        request.getRequestDispatcher(INITIAL).forward(request,response);
    }
}
