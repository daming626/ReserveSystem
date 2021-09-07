package com.example.springboot.bean;

import java.util.Date;

public class SysLog {
    private String id;
    private int log_type;
    private String log_content;
    private int operate_type;
    private String userid;
    private String username;
    private String ip;
    private String method;
    private String request_url;
    private String request_param;
    private String request_type;
    private long cost_time;
    private String create_by;
    private Date create_time;
    private String update_by;
    private String update_time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLog_type() {
        return log_type;
    }

    public void setLog_type(int log_type) {
        this.log_type = log_type;
    }

    public String getLog_content() {
        return log_content;
    }

    public void setLog_content(String log_content) {
        this.log_content = log_content;
    }

    public int getOperate_type() {
        return operate_type;
    }

    public void setOperate_type(int operate_type) {
        this.operate_type = operate_type;
    }

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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRequest_url() {
        return request_url;
    }

    public void setRequest_url(String request_url) {
        this.request_url = request_url;
    }

    public String getRequest_param() {
        return request_param;
    }

    public void setRequest_param(String request_param) {
        this.request_param = request_param;
    }

    public String getRequest_type() {
        return request_type;
    }

    public void setRequest_type(String request_type) {
        this.request_type = request_type;
    }

    public long getCost_time() {
        return cost_time;
    }

    public void setCost_time(long cost_time) {
        this.cost_time = cost_time;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "SysLog{" +
                "id='" + id + '\'' +
                ", log_type=" + log_type +
                ", log_content='" + log_content + '\'' +
                ", operate_type=" + operate_type +
                ", userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", ip='" + ip + '\'' +
                ", method='" + method + '\'' +
                ", request_url='" + request_url + '\'' +
                ", request_param='" + request_param + '\'' +
                ", request_type='" + request_type + '\'' +
                ", cost_time=" + cost_time +
                ", create_by='" + create_by + '\'' +
                ", create_time=" + create_time +
                ", update_by='" + update_by + '\'' +
                ", update_time='" + update_time + '\'' +
                '}';
    }
}
