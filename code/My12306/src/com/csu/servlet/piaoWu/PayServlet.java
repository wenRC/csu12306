package com.csu.servlet.piaoWu;

import com.csu.domain.order.Order;
import com.csu.domain.piaoWu.PiaoWu;
import com.csu.service.GetPiaoWuAndYuPIaoService;
import com.csu.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 温 睿诚 on 2016/9/19/0019.
 */
@WebServlet(name = "PayServlet",urlPatterns = {"/pay"})
public class PayServlet extends HttpServlet {
    private static final String url="/WEB-INF/jsp/order/searchOrder.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        ArrayList<PiaoWu> piaoWus= (ArrayList<PiaoWu>) session.getAttribute("piaowus");
        int orderId=piaoWus.get(Integer.parseInt(req.getParameter("index"))).getOrderId();
        OrderService orderService=new OrderService();
        Order order=orderService.getOrderByOrderId(orderId);
        order.setOrderStatus("已支付");
        orderService.updateOrder(order);
        session.setAttribute("infomsg","订单号："+order.getOrderId()+" 支付成功");
        piaoWus=new GetPiaoWuAndYuPIaoService().getPiaoWuByUserId(order.getPassengerId());
        session.setAttribute("piaowus",piaoWus);
        req.getRequestDispatcher(url).forward(req,resp);
    }
}
