package com.example.lab3.service;

import com.example.lab3.domain.User;
import com.example.lab3.dtos.PostDto;
import com.example.lab3.dtos.RoleDto;
import com.example.lab3.dtos.UserDto;

import java.util.List;

public interface UserService {
    public List<UserDto> findAll();
    public UserDto findById(long id);
    public UserDto findByUsername(String username);
    public UserDto save(UserDto userDto);
    public RoleDto saveRole(RoleDto roleDto);
    public void addRoleToUser(String username, String role);
    public void deleteRole(RoleDto roleDto);
    public void deleteById(long id);
    public void delete(UserDto userDto);
    public UserDto update(long id, UserDto userDto);
    public List<PostDto> findAllWithPost();
}
