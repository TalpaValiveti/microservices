package com.talpa.employee_service.controller;

import com.talpa.employee_service.model.Department;
import com.talpa.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}/department")
    public Department getEmployeeDepartment(@PathVariable Long id) {
        return employeeService.getDepartmentById(id);
    }
}
