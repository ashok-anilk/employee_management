package com.emp.employeemanagement.api.model;

//import com.sun.xml.internal.ws.developer.Serialization;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employee_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee implements Serializable {

    private static final long serialVersionUID = 5936718157054717905L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name")
    private String Name;

    @Column(name = "DOB")
    private String dBirth;

    @Column(name = "Address")
    private String address;

    @Column(name = "Salary")
    private BigDecimal salary;

    @Column(name = "Job_Title")
    private String jobTitle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name = "Joining_Date")
    private LocalDate joiningDate;

    @Column(name = "Yearly_Bonus")
    private BigDecimal yBonus;

    @Column(name = "Reporting_Mngr")
    private String reportingMngr;

    @Column(name = "Phone")
    private String phone;

}
