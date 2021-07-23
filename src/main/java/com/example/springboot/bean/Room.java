package com.example.springboot.bean;

public class Room {
    private  String roomId;
    private String roomName;
    private String roomCapacity;
    private String roomDescribe;

    public Room(){

    }

    public Room(String roomId,String roomName,String roomCapacity,String roomDescribe){
        this.roomId=roomId;
        this.roomName=roomName;
        this.roomCapacity=roomCapacity;
        this.roomDescribe=roomDescribe;
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
}
