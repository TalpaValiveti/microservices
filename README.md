============================================
Employee–Department Microservices System
============================================
- Developer: Talpa Saivaliveti
- Date: November 24, 2025
- Technology Stack: Microservices, Spring Boot, Eureka
- Version: 1.0
-------------------------------------------

PROJECT OVERVIEW
-------------------------------------------
A simple microservices demo built using Spring Boot and Spring Cloud.
This project includes:
  - Eureka Server – service registry
  - Employee Service – manages employees & calls Department Service
  - Department Service – manages departments.

-------------------------------------------
ARCHITECTURE OVERVIEW 
-------------------------------------------
                +---------------------+
                |     Eureka Server   |
                |   (Service Registry)|
                +----------+----------+
                           |
        ----------------------------------------
        |                                      |
+----------------------+         +-----------------------+
|   Employee Service   | <---->  |   Department Service  |
|  (Feign Client)      |         |   (REST APIs)         |
+----------------------+         +-----------------------+

-------------------------------------------
MODULES
-------------------------------------------
1. Eureka Server (Service Registry)
  - Central registry where all microservices register.
  - Monitors active services and their health.
  - Provides service discovery for inter-service communication.
2. Employee Service
  - CRUD operations for Employee data.
  - Stores employee name, departmentId, role, etc.
  - Acts as a Feign Client to call Department Service.
  - Endpoint to fetch Employee + Department combined details.
  - Automatically registers itself with Eureka.
3. Department Service
  - CRUD operations for Department details.
  - Stores department name, location, manager info, etc.
  - Exposes REST endpoints used by Employee Service.
  - Registers with Eureka for service discovery.
4. Inter-Service Communication (Feign Client)
  - Employee Service uses Feign Client to call Department Service: /departments/{id}
  - Provides clean and declarative REST calls without RestTemplate.
  - Demonstrates distributed service communication.
    
-------------------------------------------
RESULTS & VERIFICATIONS
-------------------------------------------
- Both Employee Service and Department Service are visible on Eureka Dashboard.
- Feign Client communication verified successfully:GET /employees/{id}/department
- Confirmed correct output:
{
  "id": 1,
  "name": "John",
  "department": {
    "id": 1,
    "name": "IT",
    "location": "NYC"
  }
}
- All services run independently and register dynamically.
- Verified stable service-to-service calls without hardcoded URLs.

-------------------------------------------
FUTURE ENHANCEMENTS
-------------------------------------------
- Add API Gateway (Spring Cloud Gateway).
- Add centralized configuration using Spring Cloud Config Server.
- Implement service logs with ELK or Grafana Loki.
- Add Docker and Kubernetes deployment support.
- Add distributed tracing using Zipkin/Jaeger.
  
-------------------------------------------
EXECUTION GUIDE
-------------------------------------------
1. Start Eureka Server
- cd eureka-server
- mvn spring-boot:run
- Access Dashboard: http://localhost:8761
2. Start Department Service
- cd department-service
- mvn spring-boot:run
- Runs on: 8081
3. Start Employee Service
- cd employee-service
- mvn spring-boot:run
- Runs on: 8082
4. Test the Inter-Service API
- http://localhost:8082/employees/1/department

-------------------------------------------
PROJECT STATUS
-------------------------------------------
Eureka Server Running
Employee & Department Services Registered
Feign Client Implemented for Service Communication
Inter-service API Returning Combined Data
Microservices Fully Functional

-------------------------------------------
END OF README
-------------------------------------------
