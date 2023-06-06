package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.sign")
@ComponentScan(basePackages = "com.example")
@ComponentScan(basePackages = "com.chat")
@ComponentScan(basePackages = "com.friend.service")
@MapperScan(basePackages = "com.friend.service")
@MapperScan(basePackages = "com.example")
@MapperScan(basePackages = "com.chat")
@MapperScan(basePackages = "com.sign")
public class KakaotalkCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(KakaotalkCloneApplication.class, args);
	}

}
