package com.csu.domain.trainGrouped;

/**
 * Created by sx on 2016/9/15.
 */
public class TrainGrouped {
    private int trainGroupedId;
    private int trainId;
    private int chexiang;
    private String seatType;
    private int seatNumber;
    private String chexiangType;

    public TrainGrouped(){}
    public TrainGrouped(int trainGroupedId, int trainId, int chexiang, String seatType, int seatNumber, String chexiangType) {
        this.trainGroupedId = trainGroupedId;
        this.trainId = trainId;
        this.chexiang = chexiang;
        this.seatType = seatType;
        this.seatNumber = seatNumber;
        this.chexiangType = chexiangType;
    }

    public int getTrainGroupedId() {
        return trainGroupedId;
    }

    public void setTrainGroupedId(int trainGroupId) {
        this.trainGroupedId = trainGroupId;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public int getChexiang() {
        return chexiang;
    }

    public void setChexiang(int chexiang) {
        this.chexiang = chexiang;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getChexiangType() {
        return chexiangType;
    }

    public void setChexiangType(String chexiangType) {
        this.chexiangType = chexiangType;
    }
}
