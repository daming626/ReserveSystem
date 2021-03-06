package com.example.springboot.mapper;

import com.example.springboot.bean.Reservate;
import com.example.springboot.exception.UserException;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReservingMapper {
    String[] getAllRoomId();
    Integer getRoomCapacity(String roomId);
    List<Reservate> viewAllReservedBySome(String date, String roomId,String seatNumber);
    Integer[] getAllReservedSeatNumber(String timestamp,String roomId);
    void insertReservate(Reservate reservate) throws UserException;
    Reservate getSomeoneStart(String timestampStart,String roomId,String seatNumber);
    Reservate getSomeoneOver(String timestampStart,String timestampOver,String roomId,String seatNumber);
}
