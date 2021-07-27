package com.example.springboot.service;

import com.example.springboot.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IManageService {

    List<User> getUserById(String roleId,int startPage, int pageSize);

    List<User> getManageById(String roleId,int startPage, int pageSize);
    void deleteManage(String userId);

    int total(int pageSize);
}