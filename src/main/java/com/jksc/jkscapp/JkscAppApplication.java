package com.jksc.jkscapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jksc")
public class JkscAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(JkscAppApplication.class, args);
	}
}
