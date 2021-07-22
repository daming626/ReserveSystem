package com.example.springboot.service;

import com.example.springboot.bean.Reservate;

import java.util.List;

public interface IReservedService {
    void cancelReservation(int sequence);
    List<Reservate> getCurrentReservedById(String userId, String currentTime);
    List<Reservate> getHistoryReservedById(String userId, String currentTime);
}
