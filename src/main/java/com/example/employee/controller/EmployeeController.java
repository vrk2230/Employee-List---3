package com.example.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeJpaService;

import java.util.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeJpaService employeeJpaService;

    @GetMapping("/employees")
    public ArrayList<Employee> getEmployees() {
        return employeeJpaService.getEmployees();
    }

    @GetMapping("/employees/{empId}")
    public Employee getEmployeeById(@PathVariable("empId") int employeeId) {
        return employeeJpaService.getEmployeebyId(employeeId);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeJpaService.addEmployee(employee);
    }

    @PutMapping("/employees/{empId}")
    public Employee updatEmployee(@PathVariable("empId") int employeeId, @RequestBody Employee employee) {
        return employeeJpaService.updateEmployee(employeeId, employee);
    }

    @DeleteMapping("/employees/{empId}")
    public void deleteEmployee(@PathVariable("empId") int employeeId) {
        employeeJpaService.deleteEmployee(employeeId);
    }
}