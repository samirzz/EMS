package com.employee.EMS.service;

import com.employee.EMS.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee employee);
    List<Employee> getEmployee();

    Employee updateEmployee(int id);

    void deleteById(int id);
}
