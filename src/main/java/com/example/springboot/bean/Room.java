package com.example.springboot.bean;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private  String roomId;
    private String roomName;
    private String roomCapacity;
    private String roomDescribe;
    List<Repair> repairList = new ArrayList<Repair>();

    public Room(){

    }

    public Room(String roomId, String roomName, String roomCapacity, String roomDescribe, List<Repair> repairList) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomCapacity = roomCapacity;
        this.roomDescribe = roomDescribe;
        this.repairList = repairList;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(String roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public String getRoomDescribe() {
        return roomDescribe;
    }

    public void setRoomDescribe(String roomDescribe) {
        this.roomDescribe = roomDescribe;
    }

    public List<Repair> getRepairList() {
        return repairList;
    }

    public void setRepairList(List<Repair> repairList) {
        this.repairList = repairList;
    }
}
