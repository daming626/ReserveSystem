package com.example.springboot.service;

import com.example.springboot.bean.Notice;

import java.util.List;

public interface INoticeService {
    Notice getNoticeById(String id);
    List<Notice> getAllNotice();
    void insertNotice(String time,String content);
    void deleteNotice(String Id);
}
