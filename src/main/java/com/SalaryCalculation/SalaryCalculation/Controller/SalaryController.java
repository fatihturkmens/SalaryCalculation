package com.SalaryCalculation.SalaryCalculation.Controller;

import com.SalaryCalculation.SalaryCalculation.Dto.SalaryDto;
import com.SalaryCalculation.SalaryCalculation.Entity.EmployeeSalary;
import com.SalaryCalculation.SalaryCalculation.Service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;


    @PostMapping("/employee")
    public ResponseEntity<String> add(@RequestBody SalaryDto salaryDto){
        salaryService.save(salaryDto);
        return new ResponseEntity<>("kaydedildi", HttpStatus.CREATED);
    }
    @GetMapping("/information/{id}")
    public ResponseEntity<EmployeeSalary> get(@PathVariable Long id){
     EmployeeSalary employeeSalary =  salaryService.get(id);
     return new ResponseEntity<>(employeeSalary,HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeSalary>> all(){
        List<EmployeeSalary> all = salaryService.all();
        return new ResponseEntity<>(all,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        salaryService.delete(id);
        return new ResponseEntity<>("İşçi bilgileri silinmiştir",HttpStatus.OK);
    }


}
