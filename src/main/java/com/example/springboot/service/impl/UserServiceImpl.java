package com.example.springboot.service.impl;

import com.example.springboot.mapper.UserMapper;
import com.example.springboot.service.IUserService;
import com.example.springboot.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void updateUser(User user){
        userMapper.update(user);
    }

    @Override
    public void alterUser(User user){
        userMapper.alterpw(user);
    }

    @Override
    public List<User> viewUser() {
        return userMapper.viewUser();
    }

    @Override
    public User login(String username, String password) {
        return userMapper.login(username, password);
    }

    @Override
    public void deleteUser(String userid) {
        userMapper.deleteUser(userid);
    }

    @Override
    public User getUserById(String userid) {
        return userMapper.getUserById(userid);
    }

    @Override
    public void insertManagerById(String userId) {
        userMapper.insertManagerById(userId);
    }

}
