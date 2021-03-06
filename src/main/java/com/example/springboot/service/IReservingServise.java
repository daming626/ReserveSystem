package com.example.springboot.service;

import com.example.springboot.bean.Reservate;
import com.example.springboot.exception.UserException;

import java.util.List;

public interface IReservingServise {
    String[] getAllRoomId();
    Integer getRoomCapacity(String roomId);
    List<Reservate> viewAllReservedBySome(String date, String roomId, String seatNumber);
    Integer[] getAllReservedSeatNumber(String timestamp,String roomId);
    void insertReservate(Reservate reservate) throws UserException;
    Reservate getSomeoneStart(String timestampStart,String roomId,String seatNumber);
    Reservate getSomeoneOver(String timestampStart,String timestampOver,String roomId,String seatNumber);
}
