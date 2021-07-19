package com.example.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

//@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class })
@SpringBootApplication
@MapperScan("com.example.springboot.mapper")
public class SpringbootApplication {

	public static void main(String[] args) {
		System.out.println("我要启动了亲");
		SpringApplication.run(SpringbootApplication.class, args);
		System.out.println("我已经启动了亲");
	}
}
