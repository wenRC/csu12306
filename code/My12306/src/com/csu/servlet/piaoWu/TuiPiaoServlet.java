package com.csu.servlet.piaoWu;

import com.csu.domain.diaoDu.Seat;
import com.csu.domain.order.Order;
import com.csu.domain.piaoWu.PiaoWu;
import com.csu.domain.piaoWu.Ticket;
import com.csu.domain.user.User;
import com.csu.service.DiaoduService;
import com.csu.service.GetPiaoWuAndYuPIaoService;
import com.csu.service.OrderService;
import com.csu.service.PiaowuService;

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
@WebServlet(name = "TuiPiaoServlet",urlPatterns = {"/tuipiao"})
public class TuiPiaoServlet extends HttpServlet {
    private static final String url = "/WEB-INF/jsp/order/searchOrder.jsp";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int index=Integer.parseInt(req.getParameter("index"));
        HttpSession session=req.getSession();
        ArrayList<PiaoWu> piaoWus= (ArrayList<PiaoWu>) session.getAttribute("piaowus");
        DiaoduService diaoduService=new DiaoduService();
        PiaowuService piaowuService=new PiaowuService();
        OrderService orderService=new OrderService();
        //退票，把seat状态改为未售，把ticket改为退票，把order订单状态改为退票
        PiaoWu piaoWu=piaoWus.get(index);
        Seat seat=diaoduService.getSeatBySeatId(piaoWu.getSeatId());
        seat.setStatus("未售");
        diaoduService.updateSeat(seat);
        Ticket ticket=piaowuService.getTicketByTickId(piaoWu.getTicketId());
        ticket.setTicketStatus("退票");
        piaowuService.updateTicket(ticket);
        Order order=orderService.getOrderByOrderId(piaoWu.getOrderId());
        order.setOrderStatus("已退票");
        orderService.updateOrder(order);
        User user= (User) session.getAttribute("user");
        piaoWus=new GetPiaoWuAndYuPIaoService().getPiaoWuByUserId(user.getUserid());
        session.setAttribute("piaowus",piaoWus);
        session.setAttribute("infomsg","订单号："+order.getOrderId()+"退票成功！");
        req.getRequestDispatcher(url).forward(req,resp);
    }
}
