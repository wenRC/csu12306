package com.csu.domain.trainGrouped;

/**
 * Created by war on 2016/9/14.
 */
public class trainGrouped {
    private int trainGroupId;
    private int trainId;
    private int chexiang;
    private String seatType;
    private int seatNumber;
    private String chexiangType;

    public int getTrainGroupId() {
        return trainGroupId;
    }

    public void setTrainGroupId(int trainGroupId) {
        this.trainGroupId = trainGroupId;
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
