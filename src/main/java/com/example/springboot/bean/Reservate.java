package com.example.springboot.bean;

import java.sql.Timestamp;

public class Reservate {
    private int sequence;//序号
    private String roomId;
    private int seatNumber;//座位号
    private String userId;
    private String startTime;//开始时间
    private String overTime;//结束时间
    private static String currentTime;//当前时间

    public Reservate() {
    }

    public Reservate(int sequence, String roomId, int seatNumber, String userId, String startTime, String overTime) {
        this.sequence = sequence;
        this.roomId = roomId;
        this.seatNumber = seatNumber;
        this.userId = userId;
        this.startTime = startTime;
        this.overTime = overTime;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getOverTime() {
        return overTime;
    }

    public void setOverTime(String overTime) {
        this.overTime = overTime;
    }

    public static String getCurrentTime() {
        return currentTime;
    }

    public static void setCurrentTime(String currentTime) {
        Reservate.currentTime = currentTime;
    }
}
