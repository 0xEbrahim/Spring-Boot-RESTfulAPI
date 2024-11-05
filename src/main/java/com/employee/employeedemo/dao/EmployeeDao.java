package com.employee.employeedemo.dao;

import com.employee.employeedemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();
    Employee save(Employee employee);
    void deleteById(int id);
    Employee findById(int id);
}
