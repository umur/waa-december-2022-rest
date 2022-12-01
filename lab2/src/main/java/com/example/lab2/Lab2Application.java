package com.example.lab2;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab2Application {

	public static void main(String[] args) {
		System.out.println("hello from server");
		SpringApplication.run(Lab2Application.class, args);

	}
	@Bean
	public ModelMapper getMapper(){
		return new ModelMapper();
	}

}
