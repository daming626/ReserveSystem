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
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private IRoomService roomService;
    //查看自习室
    @GetMapping("viewRoom.do")
    public String viewRoom(HttpServletRequest request){
        request.setAttribute("rooms",roomService.viewRoom());//作用域把对象request.setAttribute作用域中
        return "viewRoom";
    }
    //删除自习室
    @GetMapping("deleteRoom.do")
    public String deleteRoom(String roomId,HttpServletRequest request){
        roomService.deleteRoom(roomId);
        request.setAttribute("rooms",roomService.viewRoom());
        return "viewRoom";
    }
    //添加自习室
    @PostMapping("addRoom")
    public String addRoom(Room room){
        roomService.addRoom(room);
//        request.setAttribute("rooms",room);
        return "redirect:viewRoom.do";//重定向返回viewRoom.do重新查询
    }
    @GetMapping("addRoom.do")
    public String addRoom(){
        return "addRoom";
    }

    //修改自习室
    @PostMapping("updateRoom")
    public String updateRoom(Room room){
        System.out.println(room.getRoomId());
        System.out.println(room.getRoomCapacity());
        System.out.println(room.getRoomDescribe());
        roomService.updateRoom(room);
//        request.setAttribute("rooms",room);
        return "redirect:viewRoom.do";
    }

    @RequestMapping ("getRoomById")
    public String updateRoom(String roomId, Model model){
        Room room=roomService.getRoomById(roomId);
        model.addAttribute("room",room);
       // model.addAttribute("room",roomService.getRoomById(roomId));
        return "updateRoom";
    }

}
