package com.example.springboot.mapper;

import com.example.springboot.bean.Room;
import com.example.springboot.exception.RoomException;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoomMapper {
    List<Room> viewRoom(int startRow,int pageSize);
    void deleteRoom(String roomId);
    void addRoom(Room room) throws RoomException;
    Room getRoomById(String roomId);
    void updateRoom(Room room);
    int total(int pageSize);

    List<Room> getAllRoom();
    void insertRepairInfo(String roomName, String time, String types, String userId, String description);

}
