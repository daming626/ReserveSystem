package com.example.springboot.controller;


import com.example.springboot.bean.Room;
import com.example.springboot.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class RoomController {

    @Autowired
    private IRoomService roomService;
    //查看自习室
    @GetMapping("viewRoom")
    public String viewRoom(HttpServletRequest request){
        request.setAttribute("rooms",roomService.viewRoom());
        return "viewRoom";
    }
    //删除自习室
    @GetMapping("deleteRoom")
    public String deleteRoom(String roomId,HttpServletRequest request){
        roomService.deleteRoom(roomId);
        request.setAttribute("rooms",roomService.viewRoom());
        return "viewRoom";
    }
    //添加自习室
    @PostMapping("insertRoom")
    public String insertRoom(Room room){
        roomService.insertRoom(room);
//        request.setAttribute("rooms",room);
        return "redirect:viewRoom";
    }
    @GetMapping("insertRoom.do")
    public String insertRoom(){
        return "insertRoom";
    }

    //修改自习室
    @PostMapping("updateRoom")
    public String updateRoom(Room room){
        System.out.println(room.getRoomId());
        System.out.println(room.getRoomCapacity());
        System.out.println(room.getRoomDescribe());
        roomService.updateRoom(room);
//        request.setAttribute("rooms",room);
        return "redirect:viewRoom";
    }

    @RequestMapping ("getRoomById")
    public String updateRoom(String roomId, Model model){
        System.out.println("KKKKKKKKKKKKKKKK");
        Room room=roomService.getRoomById(roomId);
        model.addAttribute("room",room);
       // model.addAttribute("room",roomService.getRoomById(roomId));
        return "updateRoom";
    }

}
