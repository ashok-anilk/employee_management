package com.emp.employeemanagement.api.repository;

import com.emp.employeemanagement.api.model.Department;
import com.emp.employeemanagement.api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findDepartmentById(Long id);
}
