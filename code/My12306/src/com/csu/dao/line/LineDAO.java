package edu.perp.persistence;

import edu.perp.domain.Line;
import sun.util.calendar.BaseCalendar;

import java.util.ArrayList;

/**
 * Created by Asus_ on 2016/9/13.
 */
public interface LineDAO {
    public void addLine(String trainId, String stationName, int distance, BaseCalendar.Date fromTime,String lastTime);
    public void delLineByLineId(String lineId);
    public ArrayList<Line> searchLineByTrainId(String trainId);
    public ArrayList<Line> searchLineByStationName(String stationName);
    public Line getLineByLineId(String LineId);
    public void updateLine(String trainId, String stationName, int distance, BaseCalendar.Date fromTime,String lastTime);
}
