package com.example.springboot.mapper;


import com.example.springboot.bean.Notice;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeMapper {
    Notice getNoticeById(String id);
}
