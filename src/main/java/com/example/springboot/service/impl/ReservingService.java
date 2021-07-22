package com.example.springboot.service.impl;

import com.example.springboot.mapper.ReservingMapper;
import com.example.springboot.service.IReservingServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservingService implements IReservingServise {

    @Autowired
    private ReservingMapper reservingMapper;

    @Override
    public String[] getAllRoomId() {
        return reservingMapper.getAllRoomId();
    }

}
