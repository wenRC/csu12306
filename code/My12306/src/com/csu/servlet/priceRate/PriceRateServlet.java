package com.csu.servlet.priceRate;

import com.csu.domain.priceRate.PriceRate;
import com.csu.service.BaseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by war on 2016/9/20.
 */
@WebServlet(name = "PriceRateServlet", urlPatterns = {"/priceRate"})
public class PriceRateServlet extends HttpServlet{
    private static String priceRateModifyUrl = "/WEB-INF/jsp/priceRate/priceRateModify.jsp";
    BaseService baseService = new BaseService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        PriceRate priceRate =null;
        String ticketType = req.getParameter("ticketType");
        priceRate = baseService.getPriceRateByticketType(ticketType);
        session.setAttribute("priceRate",priceRate);
        req.getRequestDispatcher(priceRateModifyUrl).forward(req,resp);
    }
}
