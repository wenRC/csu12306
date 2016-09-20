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
import java.util.ArrayList;

/**
 * Created by war on 2016/9/20.
 */
@WebServlet(name = "PriceRateQuery", urlPatterns = {"/priceRateQuery"})
public class PriceRateQuery extends HttpServlet {
    private static String priceRateQueryAmdinUrl = "/WEB-INF/jsp/priceRate/priceRateQuery.jsp";
    BaseService baseService = new BaseService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        PriceRate priceRate = null;
        ArrayList<PriceRate> priceRates = new ArrayList<>();
        String ticketType = req.getParameter("ticketType");
        priceRate = baseService.getPriceRateByticketType(ticketType);
        priceRates.add(priceRate);
        session.setAttribute("priceRates",priceRates);
        req.getRequestDispatcher(priceRateQueryAmdinUrl).forward(req,resp);
    }
}
