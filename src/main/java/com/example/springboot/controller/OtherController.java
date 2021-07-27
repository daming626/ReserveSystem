package com.example.springboot.controller;

import com.example.springboot.bean.Notice;
import com.example.springboot.bean.Room;
import com.example.springboot.service.INoticeService;
import com.example.springboot.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/other")
public class OtherController {

    @Autowired
    private INoticeService noticeService;

    @Autowired
    private IRoomService roomService;

    @GetMapping("notice.do")
    public String getNotice(String id, Model model){

        Notice notice = noticeService.getNoticeById(id);
        model.addAttribute("notice",notice);

        return "notice";
    }

    @GetMapping("getAllNotice.do")
    public String getAllNotice(Model model){
        List<Notice> noticeList = noticeService.getAllNotice();
        model.addAttribute("noticeList",noticeList);
        return "viewNotice";
    }


    @GetMapping("repair.do")
    public String Report(Room room, Model model){

        List<Room> roomList = roomService.getAllRoom();
        model.addAttribute("roomList",roomList);
        return "repair";
    }

    @PostMapping("updateRepair.do")
    public String UpdateRepair(String roomName,String types, String userId, String description){

        System.out.println(roomName);
        Date date = new Date();
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        String time  = sdf.format(date);
        String id = "5";

        roomService.insertRepairInfo(id,roomName,time,types,userId,description);

        return "success";
    }
}
