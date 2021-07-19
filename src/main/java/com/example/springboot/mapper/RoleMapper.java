package com.example.springboot.mapper;

import com.example.springboot.bean.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper {
    Role getRoleByUserId(String userId);
}
