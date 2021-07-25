package com.example.springboot.controller;

import com.example.springboot.bean.Reservate;
import com.example.springboot.bean.Result;
import com.example.springboot.service.IReservingServise;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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

    @GetMapping("getSomeoneStart.do")
    public void getSomeone(String reservingDate, String roomId, String seatNumber, String startTime, HttpServletResponse response){
        response.setContentType("application/json;charset=UTF-8");
        Gson gson=new Gson();
        PrintWriter out= null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (startTime.equals("null")){
            Result result=new Result("reserveToNo");//根据此标记来放不同的图片
            out.write(gson.toJson(result));
            out.flush();
            out.close();
        }else{
            String timestampStart = reservingDate+" "+startTime;
            Reservate reservate = reservingServise.getSomeoneStart(timestampStart,roomId,seatNumber);
            if (reservate!=null){
                Result result=new Result("reserveToNo");
                out.write(gson.toJson(result));
            }else{
                Result result=new Result("reserveToYes");
                out.write(gson.toJson(result));
            }
            out.flush();
            out.close();
        }
    }

    @GetMapping("getSomeoneOver.do")
    public void getSomeoneOver(String reservingDate, String roomId, String seatNumber, String startTime,String overTime, HttpServletResponse response){
        System.out.println(startTime);
        System.out.println(overTime);
        response.setContentType("application/json;charset=UTF-8");
        Gson gson=new Gson();
        PrintWriter out= null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (startTime.equals("null")||overTime.equals("null")){
            Result result=new Result("reserveToNo");//根据此标记来放不同的图片
            out.write(gson.toJson(result));
            out.flush();
            out.close();
        }else{
            int flag = overTime.compareTo(startTime);//startTime是否比overTime大，是为1，否为-1，等于为0
            if (flag>=0){
                String timestampStart = reservingDate+" "+startTime;
                System.out.println(timestampStart);
                String timestampOver = reservingDate+" "+overTime;
                System.out.println(timestampOver);
                Reservate reservate = reservingServise.getSomeoneOver(timestampStart,timestampOver,roomId,seatNumber);
                if (reservate!=null){
                    Result result=new Result("reserveToNo");
                    out.write(gson.toJson(result));
                }else{
                    Result result=new Result("reserveToYes");
                    out.write(gson.toJson(result));
                }
                out.flush();
                out.close();
            }else if(flag<0){
                Result result=new Result("reserveToNo");
                out.write(gson.toJson(result));
                out.flush();
                out.close();
            }
        }
    }

    @PostMapping("insertReservate.do")
    public String insertReservate(String reservingDate, Reservate reservate) {
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
        return "reservingReal";
    }
}
