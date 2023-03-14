package com.diatoz.asynchronous.service;

import com.diatoz.asynchronous.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class EmployeeService {

    @Async
    public CompletableFuture<List<Employee>> getAllEmployees() throws InterruptedException {
        log.info("------getAllEmployees started------");
        Employee employees = new Employee();
        employees.setId(1L);
        employees.setName("Malashree");
        employees.setRole("Testing");
        Thread.sleep(6000L);
        log.info("------getAllEmployees completed------");
        return CompletableFuture.completedFuture(Collections.singletonList(employees));
    }

    @Async
    public CompletableFuture<String> getEmployeeRoleById() throws InterruptedException {
        log.info("------getEmployeeRoleById started-----");
        Thread.sleep(4000L);
        log.info("------getEmployeeRoleById completed-----");
        return CompletableFuture.completedFuture("developer");
    }

    public Employee getEmployeeById(Long id) throws InterruptedException {
        log.info("------getEmployeeById started------");
        Employee employee = new Employee();
        employee.setId(2L);
        employee.setName("Sharan");
        employee.setRole("Testing");
        Thread.sleep(6000L);
        log.info("------getEmployeeById completed-----");
        return employee;
    }


}



