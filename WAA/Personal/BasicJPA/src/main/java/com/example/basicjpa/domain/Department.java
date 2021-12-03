package com.example.basicjpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Department {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    private List<Course> courses;
}
