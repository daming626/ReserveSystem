package com.example.springboot.service.impl;

import com.example.springboot.bean.Reservate;
import com.example.springboot.mapper.ReservedMapper;
import com.example.springboot.service.IReservedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservedServiceImpl implements IReservedService {

    @Autowired
    private ReservedMapper reservedMapper;

    //取消预约
    @Override
    public void cancelReservation(int sequence) {
        reservedMapper.cancelReservation(sequence);
    }

    //当前预约
    @Override
    public List<Reservate> getCurrentReservedById(String userId, String currentTime, int startPage, int pageSize) {
        return reservedMapper.getCurrentReservedById(userId, currentTime, startPage, pageSize);
    }

    @Override
    public int totalc(int pageSize, String userId, String currentTime) {
        return reservedMapper.totalc(pageSize,userId,currentTime);
    }

    //历史预约
    @Override
    public List<Reservate> getHistoryReservedById(String userId, String currentTime, int startPage, int pageSize) {
        return reservedMapper.getHistoryReservedById(userId, currentTime, startPage, pageSize);
    }

    @Override
    public int totalh(int pageSize, String userId, String currentTime) {
        return reservedMapper.totalh(pageSize,userId,currentTime);
    }

}