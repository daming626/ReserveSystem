package com.example.springboot.controller;

import com.example.springboot.bean.Notice;
import com.example.springboot.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/other")
public class NoticeController {

    @Autowired
    private INoticeService noticeService;

    @GetMapping("notice.do")
    public String getNotice(String id, Model model){

        Notice notice = noticeService.getNoticeById(id);
        model.addAttribute("notice",notice);

        return "notice";
    }
}
