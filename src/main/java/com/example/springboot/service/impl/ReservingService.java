package com.example.springboot.service.impl;

import com.example.springboot.bean.Reservate;
import com.example.springboot.exception.UserException;
import com.example.springboot.mapper.ReservingMapper;
import com.example.springboot.service.IReservingServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservingService implements IReservingServise {

    @Autowired
    private ReservingMapper reservingMapper;

    @Override
    public String[] getAllRoomId() {
        return reservingMapper.getAllRoomId();
    }

    @Override
    public Integer getRoomCapacity(String roomId) {
        return reservingMapper.getRoomCapacity(roomId);
    }

    @Override
    public List<Reservate> viewAllReservedBySome(String date, String roomId, String seatNumber) {
        return reservingMapper.viewAllReservedBySome(date,roomId,seatNumber);
    }

    @Override
    public Integer[] getAllReservedSeatNumber(String timestamp, String roomId) {
        return reservingMapper.getAllReservedSeatNumber(timestamp,roomId);
    }

    @Override
    @Transactional(rollbackFor = UserException.class)
    public void insertReservate(Reservate reservate) throws UserException {
        try {
            reservingMapper.insertReservate(reservate);
        } catch (Exception e) {
            throw new UserException("预约失败");
        }
    }

    @Override
    public Reservate getSomeoneStart(String timestampStart, String roomId, String seatNumber) {
        return reservingMapper.getSomeoneStart(timestampStart,roomId,seatNumber);
    }

    @Override
    public Reservate getSomeoneOver(String timestampStart, String timestampOver, String roomId, String seatNumber) {
        return reservingMapper.getSomeoneOver(timestampStart,timestampOver,roomId,seatNumber);
    }

}
