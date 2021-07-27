package com.example.springboot.bean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String username;
    private String password;
    private String realName;
    private String sex;
    private String tclass;
    private String grade;
    private String contacts;
    private String state;
    List<Role> roleList = new ArrayList<Role>();

    public User() {
    }

    public User(String userId, String username, String password, String realName, String sex, String tclass, String grade, String contacts, String state, Timestamp registerTime, List<Role> roleList) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.sex = sex;
        this.tclass = tclass;
        this.grade = grade;
        this.contacts = contacts;
        this.state = state;
        this.roleList = roleList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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
}
