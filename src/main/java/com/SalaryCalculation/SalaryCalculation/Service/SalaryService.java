package com.SalaryCalculation.SalaryCalculation.Service;

import com.SalaryCalculation.SalaryCalculation.Dto.SalaryDto;
import com.SalaryCalculation.SalaryCalculation.Entity.EmployeeSalary;

import java.util.List;

public interface SalaryService {
    public String save(SalaryDto salaryDto);
    public EmployeeSalary get(Long id);
    public List<EmployeeSalary> all();
    public String delete(Long id);
}
