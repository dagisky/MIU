package com.example.lab3.dtos;

import com.example.lab3.domain.Post;
import com.example.lab3.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private long id;
    private String name;
    private String username;
    private String password;
    private List<Role> roles;
    private List<Post> posts;
}
