package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.ErrorHandler;

@SpringBootApplication
public class SpringBootProjectJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectJpaApplication.class, args);
	}
	
	@Bean
	public ErrorHandler errorHandler() {
		return new ErrorHandler();
	}

}
