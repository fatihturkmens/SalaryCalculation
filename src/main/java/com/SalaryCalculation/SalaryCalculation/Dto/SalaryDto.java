package com.SalaryCalculation.SalaryCalculation.Dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalaryDto {


    @NotEmpty(message = "İşçi adı boş bırakılamaz")
    @Size(min = 3,max = 30)
    private String employeeName;

    @NotEmpty(message = "İşçi soyadı boş bırakılamaz")
    @Size(min = 3,max = 30)
    private String employeeSurname;

    @NotEmpty(message = "Adres boş bırakılamaz")
    @Size(min = 3,max = 100)
    private String employeeAdress;

    private LocalDate employmentDate;

    private double grossSalary;
}
