package com.example.springboot.service;

import com.example.springboot.bean.User;

import java.util.List;

public interface IStudentService {
    List<User> viewStudent(int startRow,int pageSize);
    void deleteStudent(String userid);
    void insertStudent(User user);
    void updateStudent(User user);
    User getStudentbyId(String userid);
    int total(int pageSize);
}
