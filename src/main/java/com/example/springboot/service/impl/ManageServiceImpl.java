package com.example.springboot.service.impl;

import com.example.springboot.bean.User;
import com.example.springboot.mapper.ManageMapper;
import com.example.springboot.service.IManageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageServiceImpl implements IManageService {

    @Autowired
    private ManageMapper manageMapper;

    @Override
    public List<User> getUserById(String roleId,int startPage, int pageSize) {
        return manageMapper.getUserById(roleId,startPage,pageSize);
    }

    @Override
    public int totalu(int pageSize, String roleId) {
        return manageMapper.totalu(pageSize,roleId);
    }

    @Override
    public List<User> getManageById(String roleId,int startPage, int pageSize) {
        return manageMapper.getManageById(roleId,startPage,pageSize);
    }

    @Override
    public void deleteManage(String userId) {
        manageMapper.deleteManage(userId);
    }

    @Override
    public int totalm(int pageSize, String roleId) {
        return manageMapper.totalm(pageSize,roleId);
    }
}
