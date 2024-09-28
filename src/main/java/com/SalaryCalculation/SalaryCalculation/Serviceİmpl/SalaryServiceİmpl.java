package com.SalaryCalculation.SalaryCalculation.Serviceİmpl;

import com.SalaryCalculation.SalaryCalculation.Dto.SalaryDto;
import com.SalaryCalculation.SalaryCalculation.Entity.EmployeeSalary;
import com.SalaryCalculation.SalaryCalculation.Repository.SalaryRepository;
import com.SalaryCalculation.SalaryCalculation.Service.SalaryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SalaryServiceİmpl implements SalaryService {

       @Autowired
       private SalaryRepository salaryRepository;


        private String dtomapper(EmployeeSalary employeeSalary, SalaryDto salaryDto){

         employeeSalary.setEmployeeName(salaryDto.getEmployeeName());
         employeeSalary.setEmployeeSurname(salaryDto.getEmployeeSurname());
         employeeSalary.setEmployeeAdress(salaryDto.getEmployeeAdress());
         employeeSalary.setEmploymentDate(salaryDto.getEmploymentDate());
         employeeSalary.setGrossSalary(salaryDto.getGrossSalary());

         double vergilimaas= salaryDto.getGrossSalary();
         double netmaas=0;
         if (vergilimaas<20000) {
             netmaas =vergilimaas - (vergilimaas * 0.10);
         }
         else if(vergilimaas<40000) {
             netmaas = vergilimaas -(vergilimaas *0.20);
         }
         else {
             netmaas = vergilimaas -(vergilimaas *0.30);
         }


         employeeSalary.setNetSalary(netmaas);

         double vergiliyilliktoplam = (vergilimaas * 12);
         double netyilliktoplam=(netmaas*12);
         employeeSalary.setTotalGrossAnnnualSalary(vergiliyilliktoplam);

         employeeSalary.setTotalNetAnnualSalary(netyilliktoplam);
         salaryRepository.save(employeeSalary);




        return "kaydedildi";
    }
    public String save(SalaryDto salaryDto){
            dtomapper(new EmployeeSalary(),salaryDto);
            return "İşçi bilgileri kaydedildi";
    }
    public EmployeeSalary get(Long id) {
        Optional<EmployeeSalary> salary = salaryRepository.findById(id);
        if (salary.isPresent()) {
            return salary.get();
        } else {
            throw new EntityNotFoundException("İşçi maaş bilgileri bulunamadı");
        }
    }

    public List<EmployeeSalary> all() {
         return salaryRepository.findAll();
    }
    public String delete(Long id) {
        Optional<EmployeeSalary> salary = salaryRepository.findById(id);
        if (salary.isPresent()) {
            salaryRepository.deleteById(id);
            return "İşçi bilgileri silindi";
        } else {
            throw new EntityNotFoundException("İşçi bilgileri bulunamadı");
        }

    }

    }


