package com.csu.servlet.diaoDu;

import com.csu.domain.diaoDu.Seat;
import com.csu.domain.station.Station;
import com.csu.domain.train.Train;
import com.csu.service.BaseService;
import com.csu.service.DiaoduService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sx on 2016/9/19.
 */
@WebServlet(name = "DiaoDuServlet",urlPatterns = {"/diaodu"})
public class DiaoDuServlet extends HttpServlet {
    private static final String toSeatQueryUrl = "WEB-INF/jsp/diaoDu/seatAnnounce.jsp";
    private static final String toSeatModifyUrl = "WEB-INF/jsp/diaoDu/seatModify.jsp";
    DiaoduService diaoduService = new DiaoduService();
    BaseService baseService = new BaseService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String function = req.getParameter("function");
        HttpSession session = req.getSession();
        if ("query".equals(function)) {
            //按车次、车厢进行席位查询
            int trainid = Integer.parseInt(req.getParameter("trainid"));
            int chexiang = Integer.parseInt(req.getParameter("chexiang"));
            List<Seat> seatList = diaoduService.getSeatsByTrainIdAndCheXiang(trainid,chexiang);
            session.setAttribute("seatList",seatList);
            req.getRequestDispatcher(toSeatQueryUrl).forward(req,resp);
        } else if ("modify".equals(function)) {
            //修改席位信息
            int seatid = Integer.parseInt(req.getParameter("seatid"));
            Seat seat = diaoduService.getSeatBySeatId(seatid);
            session.setAttribute("seat",seat);
            List<Station> stationList = baseService.getAllStations();
            List<Train> trainList = baseService.getAllTrains();
            session.setAttribute("stationList",stationList);
            session.setAttribute("trainList",trainList);
            req.getRequestDispatcher(toSeatModifyUrl).forward(req,resp);
        } else if ("seatCount".equals(function)) {
            //进行客运统计
            String seatCountMethod = req.getParameter("seatCountMethod");
            int seatCount = 0;
            List<Seat> seatList = new ArrayList<>();
            if ("zong".equals(seatCountMethod)) {
                //按总席位进行客运统计
                seatCount = diaoduService.getAllSeatsCount();
                seatList = diaoduService.getAllSeats();
            } else if ("yishou".equals(seatCountMethod)){
                //按已售状态进行客运统计
                seatCount = diaoduService.getSeatsCountByStatus("已售");
                seatList = diaoduService.getSeatsByStatus("已售");
            } else if ("weishou".equals(seatCountMethod)) {
                //按未售状态进行客运统计
                seatCount = diaoduService.getSeatsCountByStatus("未售");
                seatList = diaoduService.getSeatsByStatus("未售");
            }
            session.setAttribute("seatCount",seatCount);
            session.setAttribute("seatList",seatList);
            req.getRequestDispatcher(toSeatQueryUrl).forward(req,resp);
        } else if ("submitModify".equals(function)) {
            //提交修改
            int seatid = Integer.parseInt(req.getParameter("seatid"));
            int trainid = Integer.parseInt(req.getParameter("trainid"));
            Timestamp date = Timestamp.valueOf(req.getParameter("date"));
            int chexiang = Integer.parseInt(req.getParameter("chexiang"));
            String seatno= req.getParameter("seatno");
            String from = req.getParameter("from");
            String to = req.getParameter("to");
            String status = req.getParameter("status");
            Seat seat = new Seat(seatid,trainid,date,chexiang,seatno,from,to,status);
            diaoduService.updateSeat(seat);
            List<Seat> seatList = new ArrayList<>();
            seatList.add(seat);
            session.setAttribute("seatList",seatList);
            req.getRequestDispatcher(toSeatQueryUrl).forward(req,resp);
        }

    }
}
