package com.example.springboot.service.impl;

import com.example.springboot.bean.Notice;
import com.example.springboot.mapper.NoticeMapper;
import com.example.springboot.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements INoticeService {

    @Autowired
    private NoticeMapper noticeMapper;


    @Override
    public Notice getNoticeById(String id) {
        return noticeMapper.getNoticeById(id);
    }
}
