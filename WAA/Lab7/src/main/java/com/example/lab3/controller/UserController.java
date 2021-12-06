package com.example.lab3.controller;

import com.example.lab3.domain.Role;
import com.example.lab3.dtos.PostDto;
import com.example.lab3.dtos.RoleDto;
import com.example.lab3.dtos.UserDto;
import com.example.lab3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<List<UserDto>> findAll(){
        return ResponseEntity.ok().body(userService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable("id") long id){
        return ResponseEntity.ok().body(userService.findById(id));
    }
    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/users").toUriString());
        return ResponseEntity.created(uri).body(userService.save(userDto));
    }
    @PostMapping("/roles")
    public ResponseEntity<RoleDto> saveRole(@RequestBody RoleDto roleDto){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/roles").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(roleDto));
    }
    @PostMapping("/roles/user/{username}")
    public ResponseEntity<?> addRoleToUser(@PathVariable("username") String username, @RequestBody Role role){
        userService.addRoleToUser(username, role.getName());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        userService.deleteById(id);
        return (ResponseEntity<?>) ResponseEntity.EMPTY;
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
