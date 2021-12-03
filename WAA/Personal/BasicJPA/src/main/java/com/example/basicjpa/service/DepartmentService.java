package com.example.basicjpa.service;

import com.example.basicjpa.domain.Department;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DepartmentService {
    public List<Department> findAll();
    public Department findById(long id);
    public Department save(Department department);
    public void delete(long id);
    public Department update(long id, Department department);
}
