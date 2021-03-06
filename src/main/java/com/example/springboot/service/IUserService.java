package com.example.springboot.service;

import com.example.springboot.bean.User;

import java.util.List;

public interface IUserService {
    List<User> viewUser();
    User login(String username, String password);
    void deleteUser(String userId);
    User getUserById(String userId);
    void insertManagerById(String userId);
    void updateUser(User user);
    void alterUser(User user);
}
