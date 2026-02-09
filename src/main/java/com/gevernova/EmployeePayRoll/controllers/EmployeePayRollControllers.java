package com.gevernova.EmployeePayRoll.controllers;

import com.gevernova.EmployeePayRoll.DTO.EmployeePayrollDTO;
import com.gevernova.EmployeePayRoll.Entity.EmployeePayroll;
import com.gevernova.EmployeePayRoll.Services.EmployeePayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeePayRollControllers {

    private final EmployeePayrollService employeePayrollService;

    /**
     * Create a new employee
     */
    @PostMapping
    public ResponseEntity<EmployeePayroll> createEmployee(
            @RequestBody EmployeePayrollDTO employeePayrollDTO) {

        EmployeePayroll savedEmployee =
                employeePayrollService.addEmployee(employeePayrollDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedEmployee);
    }

    /**
     * Get all employees
     */
    @GetMapping
    public ResponseEntity<List<EmployeePayroll>> getAllEmployees() {
        return ResponseEntity.ok(employeePayrollService.getAllEmployees());
    }

    /**
     * Get employee by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<EmployeePayroll> getEmployeeById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                employeePayrollService.getEmployeeById(id)
        );
    }

    /**
     * Update employee by ID
     */
    @PutMapping("/{id}")
    public ResponseEntity<EmployeePayroll> updateEmployee(
            @PathVariable Long id,
            @RequestBody EmployeePayrollDTO employeePayrollDTO) {

        EmployeePayroll updatedEmployee =
                employeePayrollService.updateEmployee(id, employeePayrollDTO);

        return ResponseEntity.ok(updatedEmployee);
    }

    /**
     * Delete employee by ID
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(
            @PathVariable Long id) {

        employeePayrollService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
