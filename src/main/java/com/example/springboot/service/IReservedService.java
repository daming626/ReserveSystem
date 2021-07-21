package com.example.springboot.service;

import com.example.springboot.bean.Reserved;

import java.util.List;

public interface IReservedService {
    void cancelReservation(int sequence);
    List<Reserved> getCurrentReservedById(String userId, String currentTime);
    List<Reserved> getHistoryReservedById(String userId,String currentTime);
}
