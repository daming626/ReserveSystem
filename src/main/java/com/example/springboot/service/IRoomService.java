package com.example.springboot.service;

import com.example.springboot.bean.Room;

import java.util.List;

public interface IRoomService {
    List<Room> viewRoom(int curPage,int pageSize);//返回一个数组
    void deleteRoom(String roomId);//返回一个roomId
    void addRoom(Room room);//无返回类型
    Room getRoomById(String roomId);
    void updateRoom(Room room);
    int total(int pageSize);

}
