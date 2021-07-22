package com.example.springboot.mapper;

import com.example.springboot.bean.Reservate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReservingMapper {
    String[] getAllRoomId();
    Integer getRoomCapacity(String roomId);
//    List<Reservate> viewReserved(String date, String roomId,int seatNumber);
}
