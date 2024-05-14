package com.emp.employeemanagement.api.service;

import com.emp.employeemanagement.api.exception.EmployeeNotFoundException;
import com.emp.employeemanagement.api.model.Employee;
import com.emp.employeemanagement.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){

        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {

        return employeeRepository.findAll();
    }

    public Employee findAllEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id)
            .orElseThrow(() -> new EmployeeNotFoundException
                  ("Employee by id " + id + "was not found"));
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        Employee existingEmployee =this.employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException
                        ("Employee by id " + id + "was not found"));
        this.employeeRepository.delete(existingEmployee);
    }
}
