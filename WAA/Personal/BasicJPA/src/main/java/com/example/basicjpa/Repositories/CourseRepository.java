package com.example.basicjpa.Repositories;

import com.example.basicjpa.domain.Course;
import com.example.basicjpa.domain.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
