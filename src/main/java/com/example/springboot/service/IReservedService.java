package com.example.springboot.service;

import com.example.springboot.bean.Reservate;

import java.util.List;

public interface IReservedService {
    void cancelReservation(int sequence);//根据序号删除预约记录（即取消预约）
    List<Reservate> getCurrentReservedById(String userId, String currentTime,int startPage,int pageSize);//当前预约记录数组
    int totalc(int pageSize,String userId, String currentTime);

    List<Reservate> getHistoryReservedById(String userId, String currentTime,int startPage,int pageSize);//历史预约记录数组
    int totalh(int pageSize, String userId, String currentTime);
}
