package com.employee.employeedemo.service;

import com.employee.employeedemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee save(Employee employee);
    void deleteById(int id);
    Employee findById(int id);
}
