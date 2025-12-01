package com.talpa.department_service.controller;

import com.talpa.department_service.model.Department;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable Long id) {
        Department dept = new Department();
        dept.setId(id);
        dept.setName("IT");
        dept.setLocation("NYC");
        return dept;
    }
}
