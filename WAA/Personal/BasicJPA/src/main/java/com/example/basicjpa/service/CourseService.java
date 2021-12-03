package com.example.basicjpa.service;

import com.example.basicjpa.domain.Course;

import java.util.List;

public interface CourseService {
    public List<Course> findAll();
    public Course findById(long id);
    public Course save(Course course);
    public void delete(long id);
    public Course update(long id, Course course);
}
