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

    @GetMapping("test.do")
    public String  test(String date, String roomId){
        System.out.println("KKKKKKKKKKKKKKKKKKKK");
        System.out.println(date);
        System.out.println(roomId);
        return "reservingReal";
    }
}
