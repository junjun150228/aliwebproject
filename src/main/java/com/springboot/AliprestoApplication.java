package com.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(value ={"com.ali"})
@MapperScan("com.ali.mapper")
public class AliprestoApplication {
	public static void main(String[] args) {
		 SpringApplication.run(AliprestoApplication.class,args);
	}
}