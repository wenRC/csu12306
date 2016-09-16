package com.csu.dao.piaoWu.impl;

import com.csu.dao.piaoWu.TicketDao;
import com.csu.domain.piaoWu.Ticket;

import java.util.ArrayList;

/**
 * Created by 温 睿诚 on 2016/9/16/0016.
 */
public class TicketDaoImpl implements TicketDao {
    @Override
    public boolean insertTicket(Ticket ticket) {
        return false;
    }

    @Override
    public ArrayList<Ticket> getTicketByUserId(int userId) {
        return null;
    }

    @Override
    public Ticket getTicketByTickId(int ticketId) {
        return null;
    }

    @Override
    public boolean updateTicket(Ticket ticket) {
        return false;
    }

    @Override
    public boolean deleteTicket(Ticket ticket) {
        return false;
    }
}
