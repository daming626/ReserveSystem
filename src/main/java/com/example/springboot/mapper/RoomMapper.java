package com.example.springboot.mapper;

import com.example.springboot.bean.Room;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoomMapper {
    List<Room> viewRoom();
    void deleteRoom(String roomId);
    void insertRoom(Room room);
    Room getRoomById(String roomId);
    void updateRoom(Room room);

}