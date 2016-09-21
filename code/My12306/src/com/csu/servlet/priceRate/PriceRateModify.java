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
@WebServlet(name = "PriceRateModify",urlPatterns = {"/priceRateModify"})
public class PriceRateModify extends HttpServlet{
    private static String priceRateQueryUrl = "/WEB-INF/jsp/priceRate/priceRateQuery.jsp";
    BaseService baseService = new BaseService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        PriceRate priceRate = null;
        ArrayList<PriceRate> priceRates = new ArrayList<>();
        HttpSession session = req.getSession();
        int priceRateId = Integer.parseInt(req.getParameter("priceRateId"));
        String ticketType = req.getParameter("ticketType");
        double pricerate = Double.parseDouble(req.getParameter("priceRate"));
        priceRate = new PriceRate(priceRateId,ticketType,pricerate);
        baseService.updatePriceRate(priceRate);
        priceRates.add(priceRate);
        String message ="修改成功";
        session.setAttribute("message",message);
        session.setAttribute("priceRates",priceRates);
        req.getRequestDispatcher(priceRateQueryUrl).forward(req,resp);
    }
}
