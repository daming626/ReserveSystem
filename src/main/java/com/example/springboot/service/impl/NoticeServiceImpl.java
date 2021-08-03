package com.example.springboot.service.impl;

import com.example.springboot.bean.Notice;
import com.example.springboot.mapper.NoticeMapper;
import com.example.springboot.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements INoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public Notice getNoticeById(String id) {
        return noticeMapper.getNoticeById(id);
    }

    @Override
    public List<Notice> getAllNotice() {
        return noticeMapper.getAllNotice();
    }

    @Override
    public void insertNotice(String time, String content) {
        noticeMapper.insertNotice(time,content);
    }

    @Override
    public void deleteNotice(String Id) {
        noticeMapper.deleteNotice(Id);
    }
}
