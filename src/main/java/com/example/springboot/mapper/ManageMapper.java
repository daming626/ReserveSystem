package com.example.springboot.mapper;


import com.example.springboot.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManageMapper {
    List<User> getUserById(@Param("roleId") String roleId, @Param("startPage") int startPage, @Param("pageSize") int pageSize);

    List<User> getManageById(String roleId,int startPage, int pageSize);
    void deleteManage(String userId);

    int total(int pageSize);

    void insertAdministrator(User user);
}
