package edu.perp.persistence;

import edu.perp.domain.Station;

/**
 * Created by Asus_ on 2016/9/13.
 */
public interface StationDAO {
    public void addStation(String stationName,String pinYin,String stationLocation);
    public Station getStationByStationName(String stationName);
    public Station getStationByPinYin(String pinYin);
    public void updateStation(String stationName,String pinYin,String stationLocation);
}
