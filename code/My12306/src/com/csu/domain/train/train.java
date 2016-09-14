package com.csu.domain.train;

import java.util.Date;

/**
 * Created by war on 2016/9/14.
 */
public class train {
        private int trainId;
        private String from;
        private String to;
        private Date fromTime;
        private Date toTime;
        private String last;
        private int distance;
        private int noseatnumber;
        private String type;

        public int getTrainId() {
            return trainId;
        }

        public void setTrainId(int trainId) {
            this.trainId = trainId;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public Date getFromTime() {
            return fromTime;
        }

        public void setFromTime(Date fromTime) {
            this.fromTime = fromTime;
        }

        public Date getToTime() {
            return toTime;
        }

        public void setToTime(Date toTime) {
            this.toTime = toTime;
        }

        public String getLast() {
            return last;
        }

        public void setLast(String last) {
            this.last = last;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public int getNoseatnumber() {
            return noseatnumber;
        }

        public void setNoseatnumber(int noseatnumber) {
            this.noseatnumber = noseatnumber;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
}
