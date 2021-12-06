package com.example.lab3;

import com.example.lab3.dtos.RoleDto;
import com.example.lab3.dtos.UserDto;
import com.example.lab3.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;

@EnableJpaRepositories
@SpringBootApplication
public class Lab3Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab3Application.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {return new ModelMapper();}
	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new RoleDto(1001, "USER"));
			userService.saveRole(new RoleDto(1002, "ADMIN"));
			userService.save(new UserDto(1001, "dagi", "dagiUser", "1234", new ArrayList<>(), new ArrayList<>()));
			userService.save(new UserDto(1002, "dagi1", "dagi1User", "1234", new ArrayList<>(), new ArrayList<>()));
			userService.addRoleToUser("dagiUser", "ADMIN");
			userService.addRoleToUser("dagi1User", "USER");
		};
	}
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
