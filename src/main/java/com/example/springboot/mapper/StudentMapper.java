package com.example.springboot.mapper;

import com.example.springboot.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<User> viewStudent(int startRow,int pageSize);
    void deleteStudent(String userid);
    void insertStudent(User user);
    void updateStudent(User user);
    User getStudentbyId(String userid);
    int total(int pageSize);
}
