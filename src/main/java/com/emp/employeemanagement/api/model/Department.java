package com.emp.employeemanagement.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "department_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Department implements Serializable {

    private static final long serialVersionUID = 5936718157054717906L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees;

    @Column(name = "Creation_Date")
    private LocalDate creationDate;

    @Column(name = "Department_Head")
    private String departmentHead;


}
