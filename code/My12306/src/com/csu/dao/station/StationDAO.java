package com.csu.dao.station;

import com.csu.domain.station.Station;

import java.util.List;

/**
 * Created by Asus_ on 2016/9/13.
 */
public interface StationDAO {
    List<Station> getAllStations();  //查询出所有的车站
    int addStation(Station station);
    Station getStationByStationName(String stationName);
    Station getStationByPinYin(String pinYin);
    int updateStation(Station station);
    int delStation(int stationId);

}
