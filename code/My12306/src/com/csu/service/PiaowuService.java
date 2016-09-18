package com.csu.service;

import com.csu.dao.piaoWu.TicketDao;
import com.csu.dao.piaoWu.impl.TicketDaoImpl;
import com.csu.domain.piaoWu.Ticket;

import java.util.ArrayList;

/**
 * Created by 温 睿诚 on 2016/9/16/0016.
 */
public class PiaowuService {
    private TicketDao ticketDao;
    public PiaowuService(){
        ticketDao=new TicketDaoImpl();
    }
    public boolean insertTicket(Ticket ticket){
        return ticketDao.insertTicket(ticket);
    }
    public ArrayList<Ticket> getTicketByUserId(int userId){
        return ticketDao.getTicketByUserId(userId);
    }
    public Ticket getTicketByTickId(int ticketId){
        return ticketDao.getTicketByTickId(ticketId);
    }
    /*
   price=?,tickettype=?,salestime=?,ticketstatus=?
   update ticket只能改这几项
    */
    public boolean updateTicket(Ticket ticket){
        return ticketDao.updateTicket(ticket);
    }
    public boolean deleteTicket(int ticketId){
        return ticketDao.deleteTicket(ticketId);
    }
}
