package com.gevernova.EmployeePayRoll.services;

import com.gevernova.EmployeePayRoll.dto.EmployeePayRollDTO;

import java.util.List;

/**
 * Service interface for Employee Payroll business operations.
 *
 * <p>This layer contains core business logic and acts as an
 * abstraction between the controller and persistence layers.</p>
 */
public interface EmployeePayRollService {

    /**
     * Creates a new employee payroll record.
     *
     * @param dto Employee payroll data transfer object
     * @return confirmation message or identifier of created employee
     */
    String addEmployee(EmployeePayRollDTO dto);

    /**
     * Retrieves all employee payroll records.
     *
     * @return list of employee payroll DTOs
     */
    List<EmployeePayRollDTO> getAllEmployees();

    /**
     * Retrieves an employee payroll record by ID.
     *
     * @param id unique identifier of the employee
     * @return employee payroll DTO
     */
    EmployeePayRollDTO getEmployeeById(Long id);

    /**
     * Updates an existing employee payroll record.
     *
     * @param id unique identifier of the employee
     * @param dto updated payroll details
     * @return confirmation message
     */
    String updateEmployee(Long id, EmployeePayRollDTO dto);

    /**
     * Deletes an employee payroll record by ID.
     *
     * @param id unique identifier of the employee
     */
    void deleteEmployee(Long id);
}
