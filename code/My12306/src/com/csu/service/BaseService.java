package com.csu.service;

import com.csu.dao.diYuanDiJianLv.DiYuanDiJianLvDAO;
import com.csu.dao.diYuanDiJianLv.impl.DiYuanDiJianLvDAOImpl;
import com.csu.dao.line.LineDAO;
import com.csu.dao.line.impl.LineDAOImpl;
import com.csu.dao.priceRate.PriceRateDao;
import com.csu.dao.priceRate.impl.PriceRateDaoImpl;
import com.csu.dao.quDuan.QuDuanDao;
import com.csu.dao.quDuan.impl.QuDuanDaoImpl;
import com.csu.dao.station.StationDAO;
import com.csu.dao.station.impl.StationDaoImpl;
import com.csu.dao.train.TrainDao;
import com.csu.dao.train.impl.TrainDaoImpl;
import com.csu.dao.trainGrouped.TrainGroupedDao;
import com.csu.dao.trainGrouped.impl.TrainGroupedDaoImpl;
import com.csu.domain.diYuanDiJianLv.DiYuanDiJianLv;
import com.csu.domain.line.Line;
import com.csu.domain.priceRate.PriceRate;
import com.csu.domain.quDuan.QuDuan;
import com.csu.domain.station.Station;
import com.csu.domain.train.Train;
import com.csu.domain.trainGrouped.TrainGrouped;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 温 睿诚 on 2016/9/14/0014.
 * 车站管理
 * 列车管理
 * 线路管理
 * 列车编组管理
 * 票价率管理
 * 票价绿城区段管理
 * 递远递减率管理
 * 的service都在这
 */
public class BaseService {
    private PriceRateDao priceRateDao;
    private TrainDao trainDao;
    private TrainGroupedDao trainGroupedDao;
    private QuDuanDao quDuanDao;
    private LineDAO lineDAO;
    private DiYuanDiJianLvDAO diYuanDiJianLvDAO;
    private StationDAO stationDAO;
    public BaseService() {
        priceRateDao = new PriceRateDaoImpl();
        trainDao = new TrainDaoImpl();
        trainGroupedDao = new TrainGroupedDaoImpl();
        quDuanDao = new QuDuanDaoImpl();
        lineDAO=new LineDAOImpl();
        diYuanDiJianLvDAO=new DiYuanDiJianLvDAOImpl();
        stationDAO=new StationDaoImpl();
    }

    /*
    车站管理
     */
    public List<Station> getAllStations() { //查询出所有的车站
        return stationDAO.getAllStations();
    }

    public int addStation(Station station) {
        station.setStationId(stationDAO.getMaxStationId() + 1);
        return stationDAO.addStation(station);
    }

    public Station getStationByStationName(String stationName) {
        return stationDAO.getStationByStationName(stationName);
    }

    public Station getStationByPinYin(String pinYin) {
        return stationDAO.getStationByPinYin(pinYin);
    }

    public int updateStation(Station station) {
        return stationDAO.updateStation(station);
    }

    public int delStation(int stationId) {
        return stationDAO.delStation(stationId);
    }

    /*
    票价率
     */
    public ArrayList<PriceRate> getAllPriceRate(){
        return priceRateDao.getAllPriceRate();
    }
    public PriceRate getPriceRateByticketType(String ticketType) {
        return priceRateDao.getPriceRateByticketType(ticketType);

    }

    public boolean updatePriceRate(PriceRate priceRate) {
        return priceRateDao.updatePriceRate(priceRate);
    }

    /*
    列车管理
   */
    public List<Train> getAllTrains() {
        return trainDao.getAllTrains();
    }

    public Train getTrainBytrainId(int trainId) {
        return trainDao.getTrainBytrainId(trainId);
    }

    public boolean insertTrain(Train train) {
        return trainDao.insertTrain(train);
    }

    public boolean deleteTrainBytrainId(int trainId) {
        return trainDao.deleteTrainBytrainId(trainId);
    }

    public boolean updateTrain(Train train) {
        return trainDao.updateTrain(train);
    }

    /*
    编组管理
    */
   public ArrayList<TrainGrouped> getAllTrainGroups(){
       return trainGroupedDao.getAllTrainGroups();
   }
    public TrainGrouped getTrainGroupBytrainGroupedId(int trainGroupedId){
        return trainGroupedDao.getTrainGroupBytrainGroupedId(trainGroupedId);

    }
    public TrainGrouped getTrainGroupBytrainIdAndCheXiang(int trainId, int chexiang) {
        return trainGroupedDao.getTrainGroupBytrainIdAndCheXiang(trainId, chexiang);
    }

    public boolean insertTrainGroup(TrainGrouped trainGroup) {
        return trainGroupedDao.insertTrainGroup(trainGroup);
    }

    public boolean deleteTrainGroupBytrainIdAndCheXiang(int trainId, int chexiang) {
        return trainGroupedDao.deleteTrainGroupBytrainIdAndCheXiang(trainId, chexiang);
    }

    public boolean updateTrainGroup(TrainGrouped trainGroup) {
        return trainGroupedDao.updateTrainGroup(trainGroup);
    }
    public ArrayList<TrainGrouped> getTrainGroupBytrainId(int trainId){
        return trainGroupedDao.getTrainGroupBytrainId(trainId);
    }
    /*
    区段
    */
    //查询所有的区段
    public List<QuDuan> getAllQuDuans() {
        return quDuanDao.getAllQuDuans();
    }

    //根据旅程区段编号查询区段
    public QuDuan getQuDuanById(int quDuanId) {
        return quDuanDao.getQuDuanById(quDuanId);
    }

    //修改旅程区段
    public boolean updateQuDuan(QuDuan quDuan) {
        return quDuanDao.updateQuDuan(quDuan);
    }

    /*
    线路管理
     */
    public int addLine(Line line){
        line.setLineId(lineDAO.getMaxLineId() + 1);
        return lineDAO.addLine(line);
    }
    public int delLineByLineId(int lineId){
        return lineDAO.delLineByLineId(lineId);
    }
    public ArrayList<Line> searchLineByTrainId(int trainId){
        return lineDAO.searchLineByTrainId(trainId);
    }
    public ArrayList<Line> searchLineByStationName(String stationName){
        return lineDAO.searchLineByStationName(stationName);
    }
    public Line getLineByLineId(int lineId){
        return lineDAO.getLineByLineId(lineId);
    }
    public int updateLine(Line line){
        return lineDAO.updateLine(line);
    }

    /*
    递远递减率管理
     */
    public DiYuanDiJianLv getDYDJLvByDYDJLID(int DYDJLID){
        return diYuanDiJianLvDAO.getDYDJLvByDYDJLID(DYDJLID);
    }
    public int addDYDJLv(DiYuanDiJianLv diYuanDiJianLv){
        diYuanDiJianLv.setdYDJId(diYuanDiJianLvDAO.getMaxDYDJLId() + 1);
        return diYuanDiJianLvDAO.addDYDJLv(diYuanDiJianLv);
    }
    public ArrayList<DiYuanDiJianLv> getDYDJLvs(){
        return diYuanDiJianLvDAO.getDYDJLvs();
    }
    public int updateDYDJLv(DiYuanDiJianLv diYuanDiJianLv){
        return diYuanDiJianLvDAO.updateDYDJLv(diYuanDiJianLv);
    }
    public int delDYDJLvById(int DYDJLID){
        return diYuanDiJianLvDAO.delDYDJLvById(DYDJLID);
    }

}