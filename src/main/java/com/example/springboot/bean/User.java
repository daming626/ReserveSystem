package com.example.springboot.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;



public class User{

    private String userid;
    private String username;
    private String password;
    private String realname;
    private String sex;
    private String tclass;
    private String grade;
    private String contacts;
    private String state;
    List<Role> roleList = new ArrayList<Role>();

    public String getUserid() {
        return userid;
    }
  
    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTclass() {
        return tclass;
    }

    public void setTclass(String tclass) {
        this.tclass = tclass;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public User(){

    }

    public User(String userid, String username, String password, String realname, String sex, String tclass, String grade, String contacts, String state) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.sex = sex;
        this.tclass = tclass;
        this.grade = grade;
        this.contacts = contacts;
        this.state = state;
    }


}
