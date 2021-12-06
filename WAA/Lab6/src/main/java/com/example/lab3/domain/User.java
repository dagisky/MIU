package com.example.lab3.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String username;
    private String password;
    @OneToMany(mappedBy = "author")
    private List<Post> posts;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Role> roles;
}
