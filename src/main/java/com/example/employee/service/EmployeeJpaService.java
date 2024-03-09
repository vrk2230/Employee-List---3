package com.example.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeJpaRepository;
import com.example.employee.repository.EmployeeRepository;

import java.util.*;

@Service
public class EmployeeJpaService implements EmployeeRepository {

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    @Override
    public ArrayList<Employee> getEmployees() {
        List<Employee> empList = employeeJpaRepository.findAll();
        ArrayList<Employee> employees = new ArrayList<>(empList);
        return employees;
    }

    @Override
    public Employee getEmployeebyId(int employeeId) {
        try {
            return employeeJpaRepository.findById(employeeId).get();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeJpaRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(int employeeId, Employee employee) {
        try {
            Employee updatedEmployee = employeeJpaRepository.findById(employeeId).get();
            if (updatedEmployee.getEmployeeName() != null) {
                updatedEmployee.setEmployeeName(employee.getEmployeeName());
            }
            if (updatedEmployee.getEmail() != null) {
                updatedEmployee.setEmail(employee.getEmail());
            }
            if (updatedEmployee.getDepartment() != null) {
                updatedEmployee.setDepartment(employee.getDepartment());
            }

            employeeJpaRepository.save(updatedEmployee);
            return updatedEmployee;

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteEmployee(int employeeId) {
        try {
            employeeJpaRepository.deleteById(employeeId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}