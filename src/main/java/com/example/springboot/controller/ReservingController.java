package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("reserving")
public class ReservingController {

    @GetMapping("reserve.do")
    public String reserving(){
        System.out.println("KKKKKKKKKKKKKKKKKKKK");
        return "reserving";
    }
}
