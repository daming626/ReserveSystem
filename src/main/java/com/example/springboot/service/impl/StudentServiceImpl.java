package com.example.springboot.service.impl;

import com.example.springboot.bean.User;
import com.example.springboot.mapper.StudentMapper;
import com.example.springboot.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<User> viewStudent() {
        return studentMapper.viewStudent();
    }
    @Override
    public void deleteStudent(String userid) {
        studentMapper.deleteStudent(userid);
    }
    @Override
    public void insertStudent(User user) {
        studentMapper.insertStudent(user);
    }
    @Override
    public void updateStudent(User user) {
        studentMapper.updateStudent(user);
    }
    @Override
    public User getStudentbyId(String userid) {
        return studentMapper.getStudentbyId(userid);
    }
}
