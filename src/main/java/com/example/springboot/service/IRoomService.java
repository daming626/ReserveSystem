package com.example.springboot.service;

import com.example.springboot.bean.Room;

import java.util.List;

public interface IRoomService {
    List<Room> viewRoom();
    void deleteRoom(String roomId);
    void insertRoom(Room room);
    Room getRoomById(String roomId);
    void updateRoom(Room room);
}
