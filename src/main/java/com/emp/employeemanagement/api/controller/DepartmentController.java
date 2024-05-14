package com.emp.employeemanagement.api.controller;

import com.emp.employeemanagement.api.model.Department;
import com.emp.employeemanagement.api.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService){
        this.departmentService=departmentService;
    }

    @PostMapping("/departments")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department){
        Department newDepartment = departmentService.addDepartment(department);
        return new ResponseEntity<>(newDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getAlldepartment(){
        List<Department> department= departmentService.findAllDepartment();
        return new ResponseEntity<>(department,HttpStatus.OK);
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> findDepartmentById(@PathVariable("id")Long id){
        Department department= departmentService.findAllDepartmentById(id);
        return  new ResponseEntity<>(department, HttpStatus.OK);
    }
    @PutMapping("/departments/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable ("id")Long id, @RequestBody Department department){department.setId(id);
        Department updateDepartment= departmentService.updateDepartment(department);
        return new ResponseEntity<>(updateDepartment,HttpStatus.OK);

    }
    @DeleteMapping("/departments/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable("id")Long id){
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

