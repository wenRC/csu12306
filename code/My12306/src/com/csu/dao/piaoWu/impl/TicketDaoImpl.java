package com.csu.dao.piaoWu.impl;

import com.csu.dao.piaoWu.TicketDao;
import com.csu.domain.piaoWu.Ticket;
import com.csu.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by 温 睿诚 on 2016/9/16/0016.
 */
public class TicketDaoImpl implements TicketDao {
    private static final String INSERT_TICKET="insert into ticket VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String GET_TICKET_BY_USERID="select ticketid,seatid,price,salemode,tickettype,passengertype,salestime,ticketstatus from ticket where passengerid=?";
    private static final String GET_TICKET_BY_TICKID="select seatid,price,salemode,tickettype,passengerid,passengertype,salestime,ticketstatus from ticket where ticketid=?";
    private static final String UPDATE_TICKET="UPDATE ticket set price=?,tickettype=?,salestime=?,ticketstatus=? where ticketid=?";
    private static final String DELETE_TICKET="delete from ticket where ticketid=?";

    @Override
    public boolean insertTicket(Ticket ticket) {

        boolean result=false;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_TICKET);
            preparedStatement.setInt(1,ticket.getTicketId());
            preparedStatement.setInt(2,ticket.getSeatId());
            preparedStatement.setDouble(3,ticket.getPrice());
            preparedStatement.setString(4,ticket.getSaleMode());
            preparedStatement.setString(5,ticket.getTicketType());
            preparedStatement.setInt(6,ticket.getUserId());
            preparedStatement.setString(7,ticket.getUserType());
            preparedStatement.setTimestamp(8,ticket.getSalesTime());
            preparedStatement.setString(9,ticket.getTicketStatus());
            result=preparedStatement.executeUpdate()==1?true:false;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return result;
    }

    @Override
    public ArrayList<Ticket> getTicketByUserId(int userId) {
        ArrayList<Ticket> tickets=new ArrayList<>();
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_TICKET_BY_USERID);
            preparedStatement.setInt(1,userId);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Ticket ticket=new Ticket();
                ticket.setTicketId(resultSet.getInt(1));
                ticket.setSeatId(resultSet.getInt(2));
                ticket.setPrice(resultSet.getDouble(3));
                ticket.setSaleMode(resultSet.getString(4));
                ticket.setTicketType(resultSet.getString(5));
                ticket.setUserId(userId);
                ticket.setUserType(resultSet.getString(6));
                ticket.setSalesTime(resultSet.getTimestamp(7));
                ticket.setTicketStatus(resultSet.getString(8));
                tickets.add(ticket);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return tickets;
        
    }

    @Override
    public Ticket getTicketByTickId(int ticketId) {
        Ticket ticket=null;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_TICKET_BY_TICKID);
            preparedStatement.setInt(1,ticketId);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                ticket=new Ticket();
                ticket.setTicketId(ticketId);
                ticket.setSeatId(resultSet.getInt(1));
                ticket.setPrice(resultSet.getDouble(2));
                ticket.setSaleMode(resultSet.getString(3));
                ticket.setTicketType(resultSet.getString(4));
                ticket.setUserId(resultSet.getInt(5));
                ticket.setUserType(resultSet.getString(6));
                ticket.setSalesTime(resultSet.getTimestamp(7));
                ticket.setTicketStatus(resultSet.getString(8));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return ticket;
    }

    @Override
    public boolean updateTicket(Ticket ticket) {

        boolean result=false;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_TICKET);
            preparedStatement.setDouble(1,ticket.getPrice());
            preparedStatement.setString(2,ticket.getTicketType());
            preparedStatement.setTimestamp(3,ticket.getSalesTime());
            preparedStatement.setString(4,ticket.getTicketStatus());
            preparedStatement.setInt(5,ticket.getTicketId());
            result=preparedStatement.executeUpdate()==1?true:false;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return result;
    }

    @Override
    public boolean deleteTicket(int ticketId) {
        boolean result=false;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_TICKET);
            preparedStatement.setInt(1,ticketId);
            result=preparedStatement.executeUpdate()==1;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        return result;
    }
}
