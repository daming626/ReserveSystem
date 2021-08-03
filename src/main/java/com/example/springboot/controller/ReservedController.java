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

    private String currentTime;

    private int curPagec = 1;

    private int curPageh = 1;
//    当前预约
    @GetMapping("currentReservation.do")
    public String currentReserved(Model model, String firstPage, String lastPage, String nextPage, String finalPage, HttpSession session){
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        currentTime=format.format(date);

        User user = (User) session.getAttribute("user");
        String userId = user.getUserid();

        int pageSize = 8;
        int totalPage = reservedService.totalc(pageSize,userId,currentTime);
        if (firstPage != null) {//首页
            curPagec = 1;
        }
        if (lastPage != null) {//上一页
            curPagec --;
        }
        if (nextPage != null) {//下一页
            curPagec ++;
        }
        if (finalPage != null) {//尾页
            curPagec = totalPage;
        }
        if (curPagec < 1) {//确定下界
            curPagec = 1;
        }
        if (curPagec > totalPage) {//确定上界
            if(totalPage==0){curPagec=1; }
            else {curPagec = totalPage;}
        }

        int startPage = (curPagec-1) * pageSize;;

        model.addAttribute("currentReservation", reservedService.getCurrentReservedById(userId,currentTime,startPage,pageSize));
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
    public String historyReserved(Model model,String firstPage, String lastPage, String nextPage, String finalPage, HttpSession session){

        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        currentTime = format.format(date);

        User user = (User) session.getAttribute("user");
        String userId = user.getUserid();
        int pageSize = 8;
        int totalPage = reservedService.totalh(pageSize,userId,currentTime);
        if (firstPage != null) {//首页
            curPageh = 1;
        }
        if (lastPage != null) {//上一页
            curPageh --;
        }
        if (nextPage != null) {//下一页
            curPageh ++;
        }
        if (finalPage != null) {//尾页
            curPageh = totalPage;
        }
        if (curPageh < 1) {//确定下界
            curPageh = 1;
        }
        if (curPageh > totalPage) {//确定上界
            if(totalPage==0){curPageh=1; }
            else {curPageh = totalPage;}
        }

        int startPage = (curPageh-1) * pageSize;

        model.addAttribute("historyAppointment", reservedService.getHistoryReservedById(userId,currentTime,startPage,pageSize));
        return "historyAppointment";
    }
}