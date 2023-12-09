package com.employee.EMS.service.impl;

import com.employee.EMS.entity.Employee;
import com.employee.EMS.repository.EmployeeRepository;
import com.employee.EMS.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employee addEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public List<Employee> getEmployee() {
       List<Employee> empList =  employeeRepository.findAll();

        return empList;
    }

    @Override
    public Employee updateEmployee(int id) {
        Employee employee = employeeRepository.findById(id).get();
        return employee;
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }


}
