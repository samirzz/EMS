package com.employee.EMS.controller;

import com.employee.EMS.entity.Employee;
import com.employee.EMS.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/home")
    public String homePage(Model model){
       List<Employee> employeeList =  employeeService.getEmployee();
       model.addAttribute("employee",employeeList);
        System.out.println(employeeList);
        return "home";
    }

    @GetMapping("/add")
    public String addEmployee(){
        return "addEmployee";
    }

    //create operation
    @PostMapping("/empAdd")
    public String empAdded(@ModelAttribute Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/home";
    }


    //update operation
    @GetMapping("/edit/{id}")
    public String updatEmploee(@PathVariable int id, Model model){
        Employee employee = employeeService.updateEmployee(id);
        model.addAttribute("singleEmployee",employee);
        return "updateEmployee";
    }


    @PostMapping("/updateEmp/{id}")
    public String updateEmp(@PathVariable int id , @ModelAttribute Employee employee){
        Employee empl = employeeService.updateEmployee(id);
        empl.setEmp_name(employee.getEmp_name());
        empl.setEmp_address(employee.getEmp_address());
        empl.setEmp_number(employee.getEmp_number());
        empl.setGender(employee.getGender());
        empl.setSkills(employee.getSkills());

        employeeService.addEmployee(empl);

        return "redirect:/home";
    }

    //delete operation
    @GetMapping ("/delete/{id}")
    public String deleteEmp(@PathVariable int id){
        employeeService.deleteById(id);
        return "redirect:/home";
    }
    

}
