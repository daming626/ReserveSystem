package com.example.springboot.bean;

import java.sql.Timestamp;

public class Notice {
    private String id;
    private Timestamp Time;
    private String content;

    public Notice() {
    }

    public Notice(String id, Timestamp time, String content) {
        this.id = id;
        Time = time;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getTime() {
        return Time;
    }

    public void setTime(Timestamp time) {
        Time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id='" + id + '\'' +
                ", Time=" + Time +
                ", content='" + content + '\'' +
                '}';
    }
}
