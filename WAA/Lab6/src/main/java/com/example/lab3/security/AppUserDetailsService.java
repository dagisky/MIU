package com.example.lab3.security;

import com.example.lab3.domain.SecurityUser;
import com.example.lab3.domain.User;
import com.example.lab3.dtos.UserDto;
import com.example.lab3.repo.UserRepo;
import com.example.lab3.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    private final UserService userService;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userDto = userService.findByUsername(username);
        if(userDto == null){
            throw new UsernameNotFoundException("User details not found, for the user "+username);
        }
        return new SecurityUser(modelMapper.map(userDto, User.class));
    }
}
