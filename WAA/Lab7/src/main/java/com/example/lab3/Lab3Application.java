package com.example.lab3;

import com.example.lab3.domain.Post;
import com.example.lab3.domain.Role;
import com.example.lab3.dtos.RoleDto;
import com.example.lab3.dtos.UserDto;
import com.example.lab3.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner runner(UserService userService){
		return args -> {
			userService.save(new UserDto(1, "foo", "foouser@gmail.com", "pass", new ArrayList<Post>(), new ArrayList<Role>()));
			userService.save(new UserDto(2, "lolo", "lolouser@gmail.com", "pass", new ArrayList<Post>(), new ArrayList<Role>()));
			userService.save(new UserDto(3, "bubu", "bubuuser@gmail.com", "pass", new ArrayList<Post>(), new ArrayList<Role>()));

			userService.saveRole(new RoleDto(1, "USER"));
			userService.saveRole(new RoleDto(1, "ADMIN"));
			userService.saveRole(new RoleDto(1, "MANAGER"));

			userService.addRoleToUser("foouser@gmail.com", "ADMIN");
			userService.addRoleToUser("lolouser@gmail.com", "USER");
			userService.addRoleToUser("bubuuser@gmail.com", "MANAGER");
		};
	}

}
