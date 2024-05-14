package com.emp.employeemanagement.api.service;

import com.emp.employeemanagement.api.exception.DepartmentNotFoundException;
import com.emp.employeemanagement.api.model.Department;
import com.emp.employeemanagement.api.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> findAllDepartment() {
        return departmentRepository.findAll();
    }



    public Department findAllDepartmentById(Long id) {
        return departmentRepository.findDepartmentById(id)
                .orElseThrow(() -> new DepartmentNotFoundException
                        ("Department by id " + id + "was not found"));
    }

    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public void deleteDepartment(Long id) {
        Department existingDepartment =this.departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException
                        ("Department by id " + id + "was not found"));
        this.departmentRepository.delete(existingDepartment);
    }
}
