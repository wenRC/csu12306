package com.csu.servlet.order;

import com.csu.domain.diaoDu.Seat;
import com.csu.domain.order.Order;
import com.csu.domain.order.YuPiao;
import com.csu.domain.piaoWu.PiaoWu;
import com.csu.domain.piaoWu.Ticket;
import com.csu.domain.user.User;
import com.csu.service.DiaoduService;
import com.csu.service.OrderService;
import com.csu.service.PiaowuService;
import com.sun.corba.se.internal.iiop.ORB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Random;

/**
 * Created by 温 睿诚 on 2016/9/19/0019.
 */
@WebServlet(name = "NewOrderServlet",urlPatterns = {"/newOrder"})
public class NewOrderServlet extends HttpServlet{
    private static final String url="/WEB-INF/jsp/order/newOrder.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        YuPiao yuPiao= (YuPiao) session.getAttribute("piao");

        DiaoduService diaoduService=new DiaoduService();
        Seat seat=diaoduService.getSeatBySeatId(yuPiao.getSeatId());
        seat.setStatus("已售");
        diaoduService.updateSeat(seat);
        session.setAttribute("seat",seat);
        Ticket ticket=new Ticket();
        ticket.setTicketId(seat.getSeatid()*new Random(System.currentTimeMillis()).nextInt(514288127));
        ticket.setSeatId(seat.getSeatid());
        ticket.setPrice(yuPiao.getPrice());
        ticket.setSaleMode("网络售票");
        ticket.setTicketType("一等座");
        User user= (User) session.getAttribute("user");
        ticket.setUserId(user.getUserid());
        ticket.setUserType("成人");
        ticket.setSalesTime(new Timestamp(System.currentTimeMillis()));
        PiaowuService piaowuService=new PiaowuService();
        piaowuService.insertTicket(ticket);
        session.setAttribute("ticket",ticket);
        Order order=new Order();
        order.setOrderId(user.getUserid()+ticket.getTicketId());//随便生成个订单号
        order.setPassengerId(user.getUserid());
        order.setOrderStatus("未支付");
        order.setOrderTime(new Timestamp(System.currentTimeMillis()));
        order.setTicketId(ticket.getTicketId());
        OrderService orderService=new OrderService();
        orderService.insertOrder(order);
        session.setAttribute("order",order);

        req.getRequestDispatcher(url).forward(req,resp);
    }
}
