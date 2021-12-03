package com.example.basicjpa.Repositories;

import com.example.basicjpa.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
