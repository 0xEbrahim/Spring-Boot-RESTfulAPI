package com.employee.employeedemo.rest;

import com.employee.employeedemo.entity.Employee;
import com.employee.employeedemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeRestController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){
        return employeeService.findAll() ;
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getASingleEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee == null)
            throw new RuntimeException("Employee not found - " + employeeId);
        return employee;
    }


    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee == null)
            throw new RuntimeException("Employee not found - " + employeeId);
        employeeService.deleteById(employeeId);
        return "Employee Deleted Successfully - " + employeeId;
    }
}
