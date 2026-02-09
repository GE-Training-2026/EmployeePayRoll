package com.gevernova.EmployeePayRoll.controllers;

import com.gevernova.EmployeePayRoll.dto.EmployeePayRollDTO;
import com.gevernova.EmployeePayRoll.Entity.EmployeePayRoll;
import com.gevernova.EmployeePayRoll.Entity.EmployeePayRoll;
import com.gevernova.EmployeePayRoll.dto.EmployeePayRollDTO;
import com.gevernova.EmployeePayRoll.services.EmployeePayRollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeePayRollControllers {

    private final EmployeePayRollService employeePayrollService;

    /**
     * Create a new employee
     */
    @PostMapping
    public ResponseEntity<EmployeePayRoll> createEmployee(
            @RequestBody EmployeePayRollDTO employeePayrollDTO) {

        EmployeePayRoll savedEmployee =
                employeePayrollService.addEmployee(employeePayrollDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedEmployee);
    }

    /**
     * Get all employees
     */
    @GetMapping
    public ResponseEntity<List<EmployeePayRoll>> getAllEmployees() {
        return ResponseEntity.ok(employeePayrollService.getAllEmployees());
    }

    /**
     * Get employee by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<EmployeePayRoll> getEmployeeById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                employeePayrollService.getEmployeeById(id)
        );
    }

    /**
     * Update employee by ID
     */
    @PutMapping("/{id}")
    public ResponseEntity<EmployeePayRoll> updateEmployee(
            @PathVariable Long id,
            @RequestBody EmployeePayRollDTO employeePayrollDTO) {

        EmployeePayRoll updatedEmployee =
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
