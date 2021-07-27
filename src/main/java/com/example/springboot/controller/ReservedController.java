package com.example.springboot.controller;

import com.example.springboot.bean.Reservate;
import com.example.springboot.bean.User;
import com.example.springboot.service.IReservedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("reserved")
public class ReservedController {

    @Autowired
    private IReservedService reservedService;

    private  String currentTime;

//    当前预约
    @GetMapping("currentReservation.do")
    public String currentReserved(String userId, Model model, HttpSession session){

        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        currentTime=format.format(date);

        User user = (User) session.getAttribute("user");
        userId = user.getUserid();
        List<Reservate> reservateList = reservedService.getCurrentReservedById(userId,currentTime);
        model.addAttribute("currentReservation", reservateList);
        return "currentReservation";
    }


//    取消预约
    @GetMapping("cancelReservation.do")
    public String cancelReservation(int sequence, Model model){
        reservedService.cancelReservation(sequence);
        return "redirect:currentReservation.do";
    }

//    历史预约
    @GetMapping("historyAppointment.do")
    public String historyReserved(String userId, Model model, HttpSession session){

        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        currentTime = format.format(date);

        User user = (User) session.getAttribute("user");
        userId = user.getUserid();
        List<Reservate> reservateList = reservedService.getHistoryReservedById(userId,currentTime);
        model.addAttribute("historyAppointment", reservateList);
        return "historyAppointment";
    }
}