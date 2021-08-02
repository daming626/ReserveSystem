package com.example.springboot.mapper;

import com.example.springboot.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> viewUser();
    User login(@Param("username") String username, @Param("password") String password);
    void deleteUser(String userId);
    User getUserById(String userId);
    void insertManagerById(String userId);
    void update(User user);
    void alterpw(User user);
}
