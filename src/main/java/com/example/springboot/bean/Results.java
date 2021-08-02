package com.example.springboot.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 封装返回结果
 */
public class Results implements Serializable{//一个类只有实现了Serializable接口，它的对象才是可序列化的,Serializable是一个空接口,它的目的只是简单的标识一个类的对象可以被序列化。
    private boolean flag;//执行结果，true为执行成功 false为执行失败
    private String message;//返回结果信息，主要用于页面提示信息
    private Object data;//返回数据
    private List list;
    private String results;

    public Results() {
    }

    public Results(String result) {
        this.results = result;
    }


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
