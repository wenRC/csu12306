package com.csu.dao.station;

import com.csu.domain.station.Station;

import java.util.List;

/**
 * Created by Asus_ on 2016/9/13.
 */
public interface StationDAO {
<<<<<<< HEAD
    List<Station> getAllStations();  //查询出所有的车站
    int addStation(Station station);
    Station getStationByStationName(String stationName);
    Station getStationByPinYin(String pinYin);
    int updateStation(Station station);
    int delStation(String stationId);
=======
    public int addStation(Station station);
    public Station getStationByStationName(String stationName);
    public Station getStationByPinYin(String pinYin);
    public int updateStation(Station station);
    public int delStation(int stationId);
>>>>>>> 15e3784dbf2dc504eb2070f2911c4992f09bd602
}
