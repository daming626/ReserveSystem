package com.example.springboot.service;

public interface IReservingServise {
    String[] getAllRoomId();
    Integer getRoomCapacity(String roomId);
}
