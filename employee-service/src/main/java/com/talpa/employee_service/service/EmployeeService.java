package com.talpa.employee_service.service;

import com.talpa.employee_service.model.Department;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class EmployeeService {

    private final RestTemplate restTemplate;

    public EmployeeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @CircuitBreaker(name = "departmentService", fallbackMethod = "departmentFallback")
    public Department getDepartmentById(Long id) {
        return restTemplate.getForObject(
            "http://department-service/departments/" + id, Department.class
        );
    }

    public Department departmentFallback(Long id, Throwable t) {
        // Fallback response if department-service is down
        return new Department(id, "Unknown", "Unknown");
    }
}
