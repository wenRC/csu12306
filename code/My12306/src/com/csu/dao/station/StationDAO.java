package com.csu.dao.station;

import com.csu.domain.station.Station;

/**
 * Created by Asus_ on 2016/9/13.
 */
public interface StationDAO {
    public int addStation(Station station);
    public Station getStationByStationName(String stationName);
    public Station getStationByPinYin(String pinYin);
    public int updateStation(Station station);
    public int delStation(int stationId);
}
