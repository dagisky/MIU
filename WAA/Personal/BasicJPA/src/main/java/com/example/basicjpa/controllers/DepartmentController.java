package com.example.basicjpa.controllers;

import com.example.basicjpa.domain.Course;
import com.example.basicjpa.domain.Department;
import com.example.basicjpa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;
    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping
    public List<Department> findAll(){
        return  departmentService.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable("id") long id){
        return departmentService.findById(id);
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department){
        return departmentService.save(department);
    }
}
