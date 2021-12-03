package com.example.basicjpa.service;

import com.example.basicjpa.Repositories.DepartmentRepository;
import com.example.basicjpa.domain.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService{
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void delete(long id) {
        Department department = departmentRepository.findById(id).orElse(null);
        departmentRepository.delete(department);
    }

    @Override
    public Department update(long id, Department department) {
        department.setId(id);
        return departmentRepository.save(department);
    }
}
