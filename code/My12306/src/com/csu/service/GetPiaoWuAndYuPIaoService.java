package com.csu.service;

import com.csu.domain.diYuanDiJianLv.DiYuanDiJianLv;
import com.csu.domain.diaoDu.Seat;
import com.csu.domain.line.Line;
import com.csu.domain.order.Order;
import com.csu.domain.order.YuPiao;
import com.csu.domain.piaoWu.PiaoWu;
import com.csu.domain.piaoWu.Ticket;
import com.csu.domain.train.Train;
import com.csu.domain.trainGrouped.TrainGrouped;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
        for(int i =0;i<orders.size();i++){
            PiaoWu piaowu=new PiaoWu();
            Order order=orders.get(i);
            Ticket ticket=tickets.get(i);
            Seat seat=seats.get(i);
            Train train=trains.get(i);
            piaowu.setOrderId(order.getOrderId());
            piaowu.setTicketId(order.getTicketId());
            piaowu.setOrderTime(order.getOrderTime());
            piaowu.setOrderStatus(order.getOrderStatus());
            piaowu.setTicketType(ticket.getTicketType());
            piaowu.setPrice(ticket.getPrice());
            piaowu.setTrainId(seat.getTrainid());
            piaowu.setCheXiang(seat.getChexiang());
            piaowu.setSeatNo(seat.getSeatno());
            piaowu.setFrom(seat.getFrom());
            piaowu.setTo(seat.getTo());
            piaowu.setDate(seat.getDate());
            piaowu.setLast(train.getLast());
            piaowu.setSeatId(seat.getSeatid());
            piaoWus.add(piaowu);
        }
        return piaoWus;
    }
    public ArrayList<YuPiao> getYuPiaoByStationName(String from,String to){
        ArrayList<YuPiao> yuPiaos=new ArrayList<>();
        //根据line表的stationname查到trainid（找到lineid一样的两个的trainid们，添加到arraylist）
        ArrayList<Line> lines1=baseService.searchLineByStationName(from);
        ArrayList<Line> lines2=baseService.searchLineByStationName(to);
        ArrayList<Train> trains=new ArrayList<>();
        if(lines1.size()<1||lines2.size()<1)
            return null;
        for(Line line1:lines1){
            for(Line line2:lines2){
                if(line1.getTrainId()==line2.getTrainId()){
                    Train train=baseService.getTrainBytrainId(line1.getTrainId());
                    trains.add(train);
                    break;
                }
            }
        }
        if(trains.size()<1)
            return null;
        //这样写会出现并发冲突异常 要写迭代
//        for (Train train:trains){
//            if(!train.getFrom().equals(from)){
//                trains.remove(train);
//            }
//
//        }
        Iterator<Train> iterator=trains.iterator();
        while (iterator.hasNext()){
            if(!iterator.next().getFrom().equals(from)){
                iterator.remove();
            }
        }
        if(trains.size()<1)
            return null;
        for(Train train:trains){
            YuPiao yuPiao = new YuPiao();
            yuPiao.setTrainId(train.getTrainId());
            yuPiao.setFrom(from);
            yuPiao.setTo(to);
            yuPiao.setLast(train.getLast());
            yuPiao.setPrice(getPrice(train.getDistance()));
            yuPiao.setDate(timeStamp2Date(train.getFromTime()));
            yuPiao.setTime(timeStamp2Time(train.getFromTime()));
            yuPiao.setSeatNo(0);
            ArrayList<TrainGrouped> trainGroupeds=baseService.getTrainGroupBytrainId(train.getTrainId());
            Map<Integer,String> cheXiang2SeatType=yuPiao.getCheXiang2SeatType();
            //获得该列车不同车厢的座位级别
            for(TrainGrouped trainGrouped:trainGroupeds){
                cheXiang2SeatType.put(trainGrouped.getChexiang(),trainGrouped.getSeatType());
            }
            //获得席位，统计各个级别作为可售票数
           for(Map.Entry<Integer,String> entry:cheXiang2SeatType.entrySet()){
               int chexiang=entry.getKey();
               List<Seat> seats=  diaoduService.getSeatsByTrainIdAndCheXiang(train.getTrainId(),chexiang);
               int seatNo=0;
               for(Seat seat:seats){
                   if(seat.getStatus().equals("未售")){
                       yuPiao.setSeatId(seat.getSeatid());
                       seatNo++;
                   }
               }
               int temp=yuPiao.getSeatNo()+seatNo;
               yuPiao.setSeatNo(temp);
           }

            yuPiaos.add(yuPiao);
        }

        return yuPiaos;
    }
    private double getPrice(int distance){
        ArrayList<DiYuanDiJianLv> diYuanDiJianLvs=baseService.getDYDJLvs();
        double result=0;
        double currentMax=0;
        int id=0;
        boolean flag=false;
        for(DiYuanDiJianLv diYuanDiJianLv:diYuanDiJianLvs){
            double lv=Double.parseDouble(diYuanDiJianLv.getdYDJTo());
            if(lv>currentMax && distance>lv){
                currentMax=lv;
                id=diYuanDiJianLv.getdYDJId();
            }
        }

        for(int i=1;i<=id;i++){
            DiYuanDiJianLv diYuanDiJianLv=diYuanDiJianLvs.get(i-1);
            int from = Integer.parseInt(diYuanDiJianLv.getdYDJFrom());
            int to = Integer.parseInt(diYuanDiJianLv.getdYDJTo());
            if(distance==to)
                flag=true;
            double priceRate=diYuanDiJianLv.getPriceRate();
            result+=(to-from+1)*priceRate;

        }
        //还有新的一段里程
        if(!flag){
            DiYuanDiJianLv diYuanDiJianLv=diYuanDiJianLvs.get(id-1);
            int to=Integer.parseInt(diYuanDiJianLv.getdYDJTo());
            int dist=distance-to;
            double priceRate=diYuanDiJianLvs.get(id).getPriceRate();
            int distancePerQuDuan=baseService.getQuDuanById(id+1).getDistancePerQD();
            int duan=dist/distancePerQuDuan+1;
            result+=priceRate*duan*distancePerQuDuan;
        }

        return result;

    }
    private Date timeStamp2Date(Timestamp timestamp){
        String temp=timestamp.toString();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        java.util.Date date=null;
        try {
             date= dateFormat.parse(temp);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("字符串转date失败");
        }
        return new Date(date.getTime());
    }
    private Time timeStamp2Time(Timestamp timestamp){
        return  new Time(timestamp.getTime());
    }

}
