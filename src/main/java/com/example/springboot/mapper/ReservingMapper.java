package com.example.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReservingMapper {
    String[] getAllRoomId();
    Integer getRoomCapacity(String roomId);
}
