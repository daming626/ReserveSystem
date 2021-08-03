package com.example.springboot.mapper;


import com.example.springboot.bean.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    Notice getNoticeById(String id);
    List<Notice> getAllNotice();
    void insertNotice(String time,String content);
    void deleteNotice(String Id);
}
