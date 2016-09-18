package com.csu.service;

import com.csu.domain.diaoDu.Seat;
import com.csu.domain.order.Order;
import com.csu.domain.order.YuPiao;
import com.csu.domain.piaoWu.PiaoWu;
import com.csu.domain.piaoWu.Ticket;
import com.csu.domain.train.Train;

import java.util.ArrayList;

/**
 * Created by 温 睿诚 on 2016/9/18/0018.
 */
public class GetPiaoWuAndYuPIaoService {
    OrderService orderService;
    BaseService baseService;
    PiaowuService piaowuService;
    DiaoduService diaoduService;

    public GetPiaoWuAndYuPIaoService(){
        orderService=new OrderService();
        baseService=new BaseService();
        piaowuService=new PiaowuService();
        diaoduService=new DiaoduService();
    }
    public ArrayList<PiaoWu> getPiaoWuByUserId(int userid){
        ArrayList<PiaoWu> piaoWus=new ArrayList<>();
        ArrayList<Order> orders=orderService.getOrdersByUserId(userid);
        ArrayList<Ticket> tickets=new ArrayList<>();
        for(Order order:orders){
            Ticket ticket=piaowuService.getTicketByTickId(order.getTicketId());
            tickets.add(ticket);
        }
        ArrayList<Seat> seats=new ArrayList<>();
        for(Ticket ticket:tickets){
            Seat seat=diaoduService.getSeatBySeatId(ticket.getSeatId());
            seats.add(seat);
        }
        ArrayList<Train> trains=new ArrayList<>();
        for (Seat seat:seats){
            Train train=baseService.getTrainBytrainId(seat.getTrainid());
            trains.add(train);
        }
        return piaoWus;
    }
    public ArrayList<YuPiao> getYuPiaoByStationName(String from,String to){
        ArrayList<YuPiao> yuPiaos=new ArrayList<>();

        return yuPiaos;
    }

}
