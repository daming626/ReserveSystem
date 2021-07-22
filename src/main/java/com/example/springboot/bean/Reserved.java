package com.example.springboot.bean;

import java.sql.Timestamp;

public class Reserved {
    private String roomId;
    private int userId;
    private int sequence;//序号
    private int seatNumber;//座位号
    private Timestamp startTime;//开始时间
    private Timestamp overTime;//结束时间
    private static String currentTime;//当前时间

    public Reserved() {
    }

    public Reserved(String roomId, int userId, int sequence, int seatNumber, Timestamp startTime, Timestamp overTime) {
        this.roomId = roomId;
        this.userId = userId;
        this.sequence = sequence;
        this.seatNumber = seatNumber;
        this.startTime = startTime;
        this.overTime = overTime;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getOverTime() {
        return overTime;
    }

    public void setOverTime(Timestamp overTime) {
        this.overTime = overTime;
    }

    public static String getCurrentTime() {
        return currentTime;
    }

    public static void setCurrentTime(String currentTime) {
        Reserved.currentTime = currentTime;
    }
}
