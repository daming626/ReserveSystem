package com.example.springboot.mapper;


import com.example.springboot.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManageMapper {
    List<User> getUserById(@Param("roleId") String roleId, @Param("startPage") int startPage, @Param("pageSize") int pageSize);
    int totalu(int pageSize,String roleId);

    List<User> getManageById(String roleId,int startPage, int pageSize);
    void deleteManage(String userId);
    int totalm(int pageSize,String roleId);
}
