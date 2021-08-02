package com.example.springboot.service.impl;
import com.example.springboot.bean.Room;
import com.example.springboot.exception.RoomException;
import com.example.springboot.mapper.RoomMapper;
import com.example.springboot.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomServiceImpl implements IRoomService {

    @Autowired
    private RoomMapper roomMapper;
    @Override
    public List<Room> viewRoom(int startRow,int pageSize) {
        return roomMapper.viewRoom(startRow,pageSize);
    }
    @Override
    public void deleteRoom(String roomId) {
        roomMapper.deleteRoom(roomId);
    }
    @Override
    public void addRoom(Room room) throws RoomException {
        roomMapper.addRoom(room);
    }
    @Override
    public void updateRoom(Room room) {
        roomMapper.updateRoom(room);
    }

    @Override
    public int total(int pageSize) {
        return roomMapper.total(pageSize);
    }

    @Override
    public Room getRoomById(String roomId) {
       return roomMapper.getRoomById(roomId);
   }


    @Override
    public List<Room> getAllRoom() {
        return roomMapper.getAllRoom();
    }

    @Override
    public void insertRepairInfo(String roomName,  String time,String types,String userId, String description) {
        roomMapper.insertRepairInfo(roomName,time,types,userId,description);
    }
}
