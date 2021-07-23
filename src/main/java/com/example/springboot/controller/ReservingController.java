package com.example.springboot.controller;

import com.example.springboot.bean.Reservate;
import com.example.springboot.service.IReservingServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.sql.Timestamp;

@Controller
@RequestMapping("reserving")
public class ReservingController {

    @Autowired
    private IReservingServise reservingServise;

    @GetMapping("reserve.do")
    public String reserving(Model model) {
        model.addAttribute("allRoomId", reservingServise.getAllRoomId());
        return "reserving";
    }

    @GetMapping("getRoomInformation.do")
    public String test(String date, String time, String roomId, Model model) {
        System.out.println("KKKKKKKKKKKKKKKKKKKK");
        System.out.println(date);
        System.out.println(time);
        System.out.println(roomId);
        if (time != null) {
            String timestamp = date + " " + time;
            System.out.println(timestamp);
            model.addAttribute("allSeatNumber", reservingServise.getAllReservedSeatNumber(timestamp, roomId));
            model.addAttribute("roomCapacity", reservingServise.getRoomCapacity(roomId));
        } else {
            model.addAttribute("roomCapacity", reservingServise.getRoomCapacity(roomId));
        }
        System.out.println(reservingServise.getRoomCapacity(roomId));
        model.addAttribute("reservingDate", date);
        model.addAttribute("roomId", roomId);
        return "reservingReal";
    }

    @GetMapping("viewAllReservedBySome.do")
    public String viewAllReservedBySome(String date, String roomId, String seatNumber, Model model) {
        System.out.println(date);
        System.out.println(roomId);
        System.out.println(seatNumber);
        model.addAttribute("AllReserved", reservingServise.viewAllReservedBySome(date, roomId, seatNumber));
        return "reservingReal::reservedTable";
    }

    @PostMapping("insertReservate.do")
    public void insertReservate(String reservingDate, Reservate reservate) {
        System.out.println("KKKKKKKKKKK");
        System.out.println(reservingDate);
        System.out.println(reservate.getSequence());
        System.out.println(reservate.getRoomId());
        System.out.println(reservate.getSeatNumber());
        System.out.println(reservate.getStartTime());
        System.out.println(reservate.getOverTime());
        System.out.println(reservate.getUserId());
        String startTime = reservingDate + " " + reservate.getStartTime();
        String overTime = reservingDate + " " + reservate.getOverTime();
        System.out.println(startTime);
        System.out.println(overTime);
        reservate.setStartTime(startTime);
        reservate.setOverTime(overTime);
        reservingServise.insertReservate(reservate);
    }
}
