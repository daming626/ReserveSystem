package com.example.springboot.entity;

import com.example.springboot.bean.User;

import java.io.Serializable;
import java.util.List;

/**
 * 封装返回结果
 */
public class Results implements Serializable{
    private boolean flag;//执行结果，true为执行成功 false为执行失败
    private String message;//返回结果信息，主要用于页面提示信息
    private Object data;//返回数据
    private List list;

    public static Results success(String message){
        return new Results(true,message);
    }

    public static Results success(String message, Object data){
        return new Results(true,message,data);
    }

    public static Results error(String message){
        return new Results(false,message);
    }

    public Results(boolean flag, String message) {
        super();
        this.flag = flag;
        this.message = message;
    }

    public Results(boolean flag, String message, Object data) {
        this.flag = flag;
        this.message = message;
        this.data = data;
    }

    public Results(List<User> list) {
        this.list = list;
    }

    public boolean isFlag() {
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public List getList() {
        return list;
    }
    public void setList(List list) {
        this.list = list;
    }
}
