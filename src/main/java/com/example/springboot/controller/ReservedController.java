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
    public String currentReserved(Model model, String firstPage, String lastPage, String nextPage, String finalPage, HttpSession session){

        int curPage=1;
        int pageSize = 8;
        int totalPage = reservedService.total(pageSize);
        if (firstPage != null) {//首页
            curPage = 1;
        }
        if (lastPage != null) {//上一页
            curPage --;
        }
        if (nextPage != null) {//下一页
            curPage ++;
        }
        if (finalPage != null) {//尾页
            curPage = totalPage;
        }
        if (curPage < 1) {//确定下界
            curPage = 1;
        }
        if (curPage > totalPage) {//确定上界
            curPage = totalPage;
        }

        int startPage = (curPage-1) * pageSize;

        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        currentTime=format.format(date);

        User user = (User) session.getAttribute("user");
        String userId = user.getUserId();

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

        int curPage=1;
        int pageSize = 8;
        int totalPage = reservedService.total(pageSize);
        if (firstPage != null) {//首页
            curPage = 1;
        }
        if (lastPage != null) {//上一页
            curPage --;
        }
        if (nextPage != null) {//下一页
            curPage ++;
        }
        if (finalPage != null) {//尾页
            curPage = totalPage;
        }
        if (curPage < 1) {//确定下界
            curPage = 1;
        }
        if (curPage > totalPage) {//确定上界
            curPage = totalPage;
        }

        int startPage = (curPage-1) * pageSize;

        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        currentTime = format.format(date);

        User user = (User) session.getAttribute("user");
        String userId = user.getUserId();

        model.addAttribute("historyAppointment", reservedService.getHistoryReservedById(userId,currentTime,startPage,pageSize));
        return "historyAppointment";
    }
}