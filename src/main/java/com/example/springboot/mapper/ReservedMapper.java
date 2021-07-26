package com.example.springboot.mapper;

import com.example.springboot.bean.Reservate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReservedMapper {
    void cancelReservation(int sequence);//根据序号删除预约记录（即取消预约）
//    List<Reservate> getCurrentReservedById(@Param("curPage") int curPage,@Param("pageSize") int pageSize,@Param("userId") String userId,@Param("currentTime") String currentTime);//当前预约记录数组
    List<Reservate> getCurrentReservedById(String userId,String currentTime,int startPage,int pageSize);//当前预约记录数组
    List<Reservate> getHistoryReservedById(String userId, String currentTime,int startPage,int pageSize);//历史预约记录数组

    int total(int pageSize);
}