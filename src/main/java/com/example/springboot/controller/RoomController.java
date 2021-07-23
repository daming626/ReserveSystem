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
import java.util.List;

@Controller
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private IRoomService roomService;
    private int curPage=1;

    //查看自习室
    @GetMapping("viewRoom.do")
    public String viewRoom(String firstPage,String lastPage,String nextPage,String finalPage,HttpServletRequest request){
        int totalPage = roomService.total(4);
        if (firstPage != null) {//首页
            curPage = 1;
        }
        if (lastPage != null) {//上一页
            curPage--;
        }
        if (nextPage != null) {//下一页
            curPage++;
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
//        List<Room> roomList = roomService.viewRoom(curPage, 4);
      //  request.setAttribute("roomname", roomname);
//        request.setAttribute("roomList", roomList);
        //request.getRequestDispatcher("user/viewUser.jsp").forward(request);
        request.setAttribute("rooms",roomService.viewRoom(curPage,4));//作用域把对象request.setAttribute作用域中
        return "viewRoom";
    }
    //删除自习室
    @GetMapping("deleteRoom.do")
    public String deleteRoom(String roomId,HttpServletRequest request){
        roomService.deleteRoom(roomId);
        request.setAttribute("rooms",roomService.viewRoom(1,4));
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
//    protected void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String url = request.getRequestURI();
//        if (url.contains("View")) {
//            String roomname = request.getParameter("roomname");
//            RoomMapper roomMapper = new RoomMapper();
//            int totalPage = roomMapper.total(5);
//
//            String firstPage = request.getParameter("firstPage");
//            String lastPage = request.getParameter("lastPage");
//            String nextPage = request.getParameter("nextPage");
//            String finalPage = request.getParameter("finalPage");
//
//            if (firstPage != null) {//首页
//                curPage = 1;
//            }
//            if (lastPage != null) {//上一页
//                curPage--;
//            }
//            if (nextPage != null) {//下一页
//                curPage++;
//            }
//            if (finalPage != null) {//尾页
//                curPage = totalPage;
//            }
//            if (curPage < 1) {//确定下界
//                curPage = 1;
//            }
//            if (curPage > totalPage) {//确定上界
//                curPage = totalPage;
//            }
//
//            List<Room> roomList = roomMapper.viewRoom(curPage, 5);
//
//            request.setAttribute("roomname", roomname);
//            request.setAttribute("roomList", roomList);
//            request.getRequestDispatcher("user/viewUser.jsp").forward(request, response);
//        }
//    }
}
