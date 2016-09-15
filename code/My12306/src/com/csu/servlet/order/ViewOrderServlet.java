package com.csu.servlet.order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 温 睿诚 on 2016/9/14/0014.
 */
@WebServlet(name = "ViewOrderServlet",urlPatterns = {"/ViewOrder"})
public class ViewOrderServlet extends HttpServlet {
    private static final String url="/WEB-INF/jsp/order/searchOrder.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(url).forward(request,response);
    }

}
