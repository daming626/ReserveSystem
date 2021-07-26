package com.example.springboot.bean;

import java.util.ArrayList;
import java.util.List;

public class Manage {
    private String userId;
    private String userName;
    private String realName;
    private String sex;
    private String tclass;
    private String grade;
    private String contacts;
    private String state;
    private String roleId;
    List<Role> roleList = new ArrayList<Role>();

    public Manage() {
    }

    public Manage(String userId, String userName, String realName, String sex, String tclass, String grade, String contacts, String state, String roleId, List<Role> roleList) {
        this.userId = userId;
        this.userName = userName;
        this.realName = realName;
        this.sex = sex;
        this.tclass = tclass;
        this.grade = grade;
        this.contacts = contacts;
        this.state = state;
        this.roleId = roleId;
        this.roleList = roleList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
