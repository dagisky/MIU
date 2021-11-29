package com.example.lab3;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.ModelMap;

@SpringBootApplication
public class Lab3Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab3Application.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {return new ModelMapper();}

}
