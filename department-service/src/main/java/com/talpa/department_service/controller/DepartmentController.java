package com.talpa.department_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @GetMapping("/departments")
    public String getDepartments() {
        return "List of departments: HR, IT, Finance";
    }
}
