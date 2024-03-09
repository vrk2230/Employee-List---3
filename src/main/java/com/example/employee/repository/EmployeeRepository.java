package com.example.employee.repository;

import java.util.ArrayList;

import com.example.employee.model.Employee;

public interface EmployeeRepository {
    ArrayList<Employee> getEmployees();

    Employee getEmployeebyId(int employeeId);

    Employee addEmployee(Employee employee);

    Employee updateEmployee(int employeeId, Employee employee);

    void deleteEmployee(int employeeId);

}