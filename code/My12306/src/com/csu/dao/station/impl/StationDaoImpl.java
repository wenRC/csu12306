package com.csu.dao.station.impl;

import com.csu.dao.station.StationDAO;
import com.csu.domain.station.Station;

import java.util.List;

/**
 * Created by sx on 2016/9/18.
 */
public class StationDaoImpl implements StationDAO {
    @Override
    public List<Station> getAllStations() {
        return null;
    }

    @Override
    public int addStation(Station station) {
        return 0;
    }

    @Override
    public Station getStationByStationName(String stationName) {
        return null;
    }

    @Override
    public Station getStationByPinYin(String pinYin) {
        return null;
    }

    @Override
    public int updateStation(Station station) {
        return 0;
    }

    @Override
    public int delStation(String stationId) {
        return 0;
    }
}
