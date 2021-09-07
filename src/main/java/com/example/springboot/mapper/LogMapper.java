package com.example.springboot.mapper;

import com.example.springboot.bean.SysLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LogMapper {
    void insert(SysLog sysLog);
}
