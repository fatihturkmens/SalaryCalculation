package com.SalaryCalculation.SalaryCalculation.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeSalary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeName;
    private String employeeSurname;
    private String employeeAdress;
    private LocalDate employmentDate;
    private double grossSalary;


    private double netSalary;
    private double totalGrossAnnnualSalary;
    private double totalNetAnnualSalary;




}
