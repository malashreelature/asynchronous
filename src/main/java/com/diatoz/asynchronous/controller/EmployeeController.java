package com.diatoz.asynchronous.controller;

import com.diatoz.asynchronous.model.Employee;
import com.diatoz.asynchronous.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping("/all/employee")
    public ResponseEntity<String> getAllEmployees() {
        try {

            CompletableFuture<List<Employee>> employees = employeeService.getAllEmployees();
            log.info("All Employees--> " + employees.get());
            return new ResponseEntity<>("all Employees example worked perfectly!", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/employee/{id}")
    public ResponseEntity<?> getEmployeeById(Long id) throws InterruptedException {
        try{
            Employee employee= employeeService.getEmployeeById(id);
            log.info("Employee By Id--> " + employee.getId());
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/test/{role}")
    public ResponseEntity<String> getEmployeeRoleById() {
        try {
            CompletableFuture<String> employeeRole = employeeService.getEmployeeRoleById();
            log.info("Employee Role By Id--> " + employeeRole.get());
            return new ResponseEntity<>("Employee By role worked perfectly!", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

