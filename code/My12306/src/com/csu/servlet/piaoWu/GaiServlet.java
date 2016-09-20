package com.csu.servlet.piaoWu;

import com.csu.domain.diaoDu.Seat;
import com.csu.domain.order.Order;
import com.csu.domain.order.YuPiao;
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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by 温 睿诚 on 2016/9/20/0020.
 */
@WebServlet(name = "GaiServlet",urlPatterns = {"/gai"})
public class GaiServlet extends HttpServlet {
    private static final String url="/WEB-INF/jsp/order/searchOrder.jsp";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int index= Integer.parseInt(req.getParameter("index"));
        HttpSession session=req.getSession();
        ArrayList<YuPiao> yuPiaos= (ArrayList<YuPiao>) session.getAttribute("yupiaos");
        YuPiao yuPiao=yuPiaos.get(index);
        PiaoWu piao= (PiaoWu) session.getAttribute("piao");
        //原seat设置为未售
        int seatId=piao.getSeatId();
        DiaoduService diaoduService=new DiaoduService();
        Seat seat=diaoduService.getSeatBySeatId(seatId);
        seat.setStatus("未售");
        diaoduService.updateSeat(seat);
        //获得新的seatid
        int newSeatId=yuPiao.getSeatId();
        int newTicketId=(newSeatId*new Random(System.currentTimeMillis()).nextInt(9876));
        Seat seat1=diaoduService.getSeatBySeatId(newSeatId);
        seat1.setStatus("已售");
        diaoduService.updateSeat(seat1);
        //插入新的ticket
        PiaowuService piaowuService=new PiaowuService();
        Ticket nticket=new Ticket();
        nticket.setTicketId(newTicketId);
        nticket.setSeatId(newSeatId);
        nticket.setTicketStatus("已改签");
        nticket.setSalesTime(new Timestamp(System.currentTimeMillis()));
        nticket.setPrice(yuPiao.getPrice());
        nticket.setSaleMode("网络售票");
        nticket.setTicketType("一等座");
        User user= (User) session.getAttribute("user");
        nticket.setUserId(user.getUserid());
        nticket.setUserType("成人");
        piaowuService.insertTicket(nticket);
        //order绑定新ticketid
        int orderId=piao.getOrderId();
        OrderService orderService=new OrderService();
        Order order=orderService.getOrderByOrderId(orderId);
        order.setTicketId(newTicketId);
        order.setOrderTime(new Timestamp(System.currentTimeMillis()));
        orderService.updateOrder(order);
        //删除原ticket
        int ticketId=piao.getTicketId();
        Ticket ticket=piaowuService.getTicketByTickId(ticketId);
        piaowuService.deleteTicket(ticketId);


        session.setAttribute("yupiaos",null);
        session.setAttribute("piao",null);
        session.setAttribute("infomsg","订单号："+orderId+"改签成功！");
        session.setAttribute("piaowus",new GetPiaoWuAndYuPIaoService().getPiaoWuByUserId(user.getUserid()));
        req.getRequestDispatcher(url).forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
