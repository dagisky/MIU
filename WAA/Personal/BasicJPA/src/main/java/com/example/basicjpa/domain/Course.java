package com.example.basicjpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    @ManyToMany(cascade = CascadeType.DETACH)
    private Department department;
}
