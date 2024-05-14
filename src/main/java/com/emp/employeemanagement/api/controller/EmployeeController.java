package com.emp.employeemanagement.api.controller;

import com.emp.employeemanagement.api.model.Employee;
import com.emp.employeemanagement.api.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable("id") Long id) {
        Employee employee = employeeService.findAllEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id,
                                                   @RequestBody Employee employee) {
        employee.setId(id);
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);

    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @GetMapping("/employees")
//    public ResponseEntity<List<Map<String, Object>>> listEmployeeNamesAndIds(@RequestParam(value = "lookup", required = false, defaultValue = "false") boolean lookup) {
//        if (lookup) {
//            List<Employee> employees = employeeService.findAllEmployees();
//            List<Map<String, Object>> result = employees.stream()
//                    .map(employee -> {
//                        Map<String, Object> employeeData = Map.of(
//                                "id", employee.getId(),
//                                "name", employee.getName()
//                        );
//                        return employeeData;
//                    })
//                    .collect(Collectors.toList());
//            return ResponseEntity.ok(result);
//        } else {
//            return ResponseEntity.badRequest().body(null);
//        }
//    }
}
