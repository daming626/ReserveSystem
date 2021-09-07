package com.example.springboot.service.impl;

import com.example.springboot.bean.SysLog;
import com.example.springboot.mapper.LogMapper;
import com.example.springboot.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public void insert(SysLog sysLog) {
        System.out.println(sysLog.toString());
        System.out.println(sysLog.getLog_content());
        logMapper.insert(sysLog);
    }
}
