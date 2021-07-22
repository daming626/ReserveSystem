package com.example.springboot.mapper;

import com.example.springboot.bean.Reservate;

import java.util.List;

public interface ReservedMapper {
    void cancelReservation(int sequence);
    List<Reservate> getCurrentReservedById(String userId, String currentTime);
    List<Reservate> getHistoryReservedById(String userId, String currentTime);
}
