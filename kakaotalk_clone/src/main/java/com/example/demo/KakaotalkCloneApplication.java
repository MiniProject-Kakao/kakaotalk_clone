package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
@ComponentScan(basePackages = "com.chat")
@MapperScan(basePackages = "com.example")
@MapperScan(basePackages = "com.chat")
public class KakaotalkCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(KakaotalkCloneApplication.class, args);
	}

}
