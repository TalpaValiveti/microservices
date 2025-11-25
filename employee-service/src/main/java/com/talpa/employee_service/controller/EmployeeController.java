package com.talpa.employee_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EmployeeController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/employees")
    public String getEmployees() {
        return "List of employees: Alice, Bob, Charlie";
    }

    @GetMapping("/employees-with-departments")
    public String getEmployeesWithDepartments() {
        // Call Department Service dynamically via Eureka
        String departmentUrl = "http://department-service/departments";
        String departments = restTemplate.getForObject(departmentUrl, String.class);
        return "Employees: Alice, Bob, Charlie | Departments: " + departments;
    }
}
