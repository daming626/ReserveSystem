package com.example.springboot.service;

import com.example.springboot.bean.User;

import java.util.List;

public interface IUserService {
    List<User> viewUser();
    User login(String username, String password);
    void deleteUser(String userid);
    User getUserById(String userid);
}
