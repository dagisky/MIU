package com.example.lab3.controller;

import com.example.lab3.dtos.PostDto;
import com.example.lab3.dtos.UserDto;
import com.example.lab3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<UserDto> findAll(){
        return userService.findAll();
    }
    @GetMapping("/{id}")
    public UserDto findById(@PathVariable("id") long id){
        return userService.findById(id);
    }
    @PostMapping
    public UserDto save(@RequestBody UserDto userDto){
        return userService.save(userDto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        userService.deleteById(id);
    }
    @PutMapping("/{id}")
    public UserDto update(@PathVariable("id") long id, @RequestBody UserDto userDto){
        return userService.update(id, userDto);
    }
    @GetMapping("/filter")
    public List<PostDto> findAllWithPost(){
        return userService.findAllWithPost();
    }
}
