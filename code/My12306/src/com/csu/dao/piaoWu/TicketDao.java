package com.csu.dao.piaoWu;

import com.csu.domain.piaoWu.Ticket;

import java.util.ArrayList;

/**
 * Created by 温 睿诚 on 2016/9/16/0016.
 */
public interface TicketDao {
    boolean insertTicket(Ticket ticket);
    ArrayList<Ticket> getTicketByUserId(int userId);
    Ticket getTicketByTickId(int ticketId);
    /*
    price=?,tickettype=?,salestime=?,ticketstatus=?
    update ticket只能改这几项
     */
    boolean updateTicket(Ticket ticket);
    boolean deleteTicket(int ticketId);
}
