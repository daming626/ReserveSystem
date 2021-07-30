package com.example.springboot.service;

import com.example.springboot.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IManageService {

    List<User> getUserById(String roleId,int startPage, int pageSize);
    int totalu(int pageSize, String roleId);

    List<User> getManageById(String roleId,int startPage, int pageSize);
    void deleteManage(String userId);
    int totalm(int pageSize, String roleId);

    void insertAdministrator(User user);

    List<User> searchUser(String txt,String roleId,int startPage, int pageSize);

    int totals(int pageSize, String roleId);
}