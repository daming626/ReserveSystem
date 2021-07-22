package com.example.springboot;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {

        //使用Date创建日期对象
        Date date=new Date();
        System.out.println("当前的日期是------>"+date);

        /**
         * 创建格式化时间日期类
         *构造入参String类型就是我们想要转换成的时间形式
         */
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("格式化后的时间------->"+format.format(date));
    }
}
