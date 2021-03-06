package com.example.basicjpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="department_id")
    private Department department;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 10)
    private List<Student> students;
}
