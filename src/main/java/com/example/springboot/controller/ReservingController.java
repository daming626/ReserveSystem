package com.example.springboot.controller;

import com.example.springboot.service.IReservingServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.sql.Timestamp;

@Controller
@RequestMapping("/reserving")
public class ReservingController {

    @Autowired
    private IReservingServise reservingServise;

    @GetMapping("reserve.do")
    public String reserving(Model model){
        model.addAttribute("allRoomId",reservingServise.getAllRoomId());
        return "reserving";
    }

    @GetMapping("getRoomInformation.do")
    public String  test(String date, String time,String roomId,Model model){
        System.out.println("KKKKKKKKKKKKKKKKKKKK");
        System.out.println(date);
        System.out.println(time);
        System.out.println(roomId);
        if (time!=null){
            String timestamp = date+" "+time;
            System.out.println(timestamp);
            model.addAttribute("allSeatNumber",reservingServise.getAllReservedSeatNumber(timestamp,roomId));
            model.addAttribute("roomCapacity",reservingServise.getRoomCapacity(roomId));
        }else{
            model.addAttribute("roomCapacity",reservingServise.getRoomCapacity(roomId));
        }
        System.out.println(reservingServise.getRoomCapacity(roomId));
        model.addAttribute("reservingDate",date);
        model.addAttribute("roomId",roomId);
        return "reservingReal";
    }

    @GetMapping("viewAllReservedBySome.do")
    public String viewAllReservedBySome(String date, String roomId,String seatNumber,Model model){
        System.out.println(date);
        System.out.println(roomId);
        System.out.println(seatNumber);
        model.addAttribute("AllReserved",reservingServise.viewAllReservedBySome(date,roomId,seatNumber));
        return "reservingReal::reservedTable";
    }

}
