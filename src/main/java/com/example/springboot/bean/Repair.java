package com.example.springboot.bean;

public class Repair {

    private String id;
    private String roomName;
    private String time;
    private String types;
    private String description;

    public Repair() {
    }

    public Repair(String id, String roomName, String time, String types, String description) {
        this.id = id;
        this.roomName = roomName;
        this.time = time;
        this.types = types;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "id='" + id + '\'' +
                ", roomName='" + roomName + '\'' +
                ", time='" + time + '\'' +
                ", types='" + types + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
