package com.SalaryCalculation.SalaryCalculation.Repository;

import com.SalaryCalculation.SalaryCalculation.Entity.EmployeeSalary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<EmployeeSalary,Long>{



}
