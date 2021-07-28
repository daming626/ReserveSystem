package com.example.springboot.service;

import com.example.springboot.bean.Room;

import java.util.List;

public interface IRoomService {
    List<Room> viewRoom(int startRow,int pageSize);//返回一个数组
    void deleteRoom(String roomId);//返回一个roomId
    void addRoom(Room room);//无返回类型
    Room getRoomById(String roomId);
    void updateRoom(Room room);
    int total(int pageSize);

    List<Room> getAllRoom();
    void insertRepairInfo(String roomName, String time, String types,String userId, String description);

}
