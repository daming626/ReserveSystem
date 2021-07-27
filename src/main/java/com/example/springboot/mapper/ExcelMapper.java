package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.entity.Users;
import org.apache.ibatis.annotations.Param;


public interface ExcelMapper extends BaseMapper<Users> {

    int insertProjectItem(@Param("userid") String userid, @Param("username") String username, @Param("password") String password,
                          @Param("realname") String realname, @Param("sex") String sex, @Param("tclass") String tclass, @Param("grade") String grade, @Param("contacts") String contacts);
}//@Param作用是给参数命名
