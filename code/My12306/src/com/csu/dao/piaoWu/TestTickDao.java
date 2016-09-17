package com.csu.dao.piaoWu;

import com.csu.dao.piaoWu.impl.TicketDaoImpl;
import com.csu.domain.piaoWu.Ticket;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Created by 温 睿诚 on 2016/9/17/0017.
 */
public class TestTickDao {
    public static void main(String[] args) {
        TicketDao ticketDao = new TicketDaoImpl();
        //通过测试
        //insert
//        Ticket ticket = new Ticket();
//        ticket.setTicketId(2);
//        ticket.setSeatId(1);
//        ticket.setPrice(9.99);
//        ticket.setUserId(1);
//        ticket.setUserType("儿童");
//        System.out.println(ticketDao.insertTicket(ticket));

        //delete
//        System.out.println(ticketDao.deleteTicket(2));

        //update
//        Ticket ticket=ticketDao.getTicketByTickId(1);
//        ticket.setSalesTime(new Timestamp(System.currentTimeMillis()));
//        System.out.println(ticketDao.updateTicket(ticket));
        //get ticket by userid
//        ArrayList<Ticket> tickets=ticketDao.getTicketByUserId(0);
//        System.out.println(tickets.get(0).getTicketType());
        //get ticket by ticketid
//        System.out.println(ticketDao.getTicketByTickId(1).getSaleMode());

    }
}
