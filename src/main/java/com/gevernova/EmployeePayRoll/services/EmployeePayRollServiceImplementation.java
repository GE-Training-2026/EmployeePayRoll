package com.gevernova.EmployeePayRoll.services;

import com.gevernova.EmployeePayRoll.Entity.EmployeePayRoll;
import com.gevernova.EmployeePayRoll.dto.EmployeePayRollDTO;
import com.gevernova.EmployeePayRoll.exceptions.IDNotFound;
import com.gevernova.EmployeePayRoll.repository.EmployeePayRollRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for Employee Payroll operations.
 *
 * <p>Handles business logic and coordinates between
 * controller and repository layers.</p>
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeePayRollServiceImplementation implements EmployeePayRollService {

    private final EmployeePayRollRepository employeePayrollRepository;

    /**
     * Creates a new employee payroll record.
     *
     * @param dto employee payroll details
     * @return confirmation message
     */
    @Override
    public String addEmployee(EmployeePayRollDTO dto) {
        EmployeePayRoll employee = EmployeePayRoll.builder()
                .name(dto.getName())
                .department(dto.getDepartment())
                .salary(dto.getSalary())
                .build();

        employeePayrollRepository.save(employee);
        log.info("Employee created successfully");

        return "Employee created successfully";
    }

    /**
     * Retrieves all employee payroll records.
     *
     * @return list of employee payroll DTOs
     */
    @Override
    public List<EmployeePayRollDTO> getAllEmployees() {
        log.info("Fetching all employees");

        return employeePayrollRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    /**
     * Retrieves employee payroll by ID.
     *
     * @param id employee identifier
     * @return employee payroll DTO
     */
    @Override
    public EmployeePayRollDTO getEmployeeById(Long id) {
        EmployeePayRoll employee = employeePayrollRepository.findById(id)
                .orElseThrow(() ->
                        new IDNotFound("Employee not found with id: " + id));

        log.info("Employee fetched with id: {}", id);
        return mapToDTO(employee);
    }

    /**
     * Updates employee payroll details.
     *
     * @param id employee identifier
     * @param dto updated payroll details
     * @return confirmation message
     */
    @Override
    public String updateEmployee(Long id, EmployeePayRollDTO dto) {
        EmployeePayRoll employee = employeePayrollRepository.findById(id)
                .orElseThrow(() ->
                        new IDNotFound("Employee not found with id: " + id));

        employee.setName(dto.getName());
        employee.setSalary(dto.getSalary());
        employee.setDepartment(dto.getDepartment());

        employeePayrollRepository.save(employee);
        log.info("Employee updated with id: {}", id);

        return "Employee updated successfully";
    }

    /**
     * Deletes employee payroll by ID.
     *
     * @param id employee identifier
     */
    @Override
    public void deleteEmployee(Long id) {
        if (!employeePayrollRepository.existsById(id)) {
            throw new IDNotFound("Employee not found with id: " + id);
        }

        employeePayrollRepository.deleteById(id);
        log.info("Employee deleted with id: {}", id);
    }

    /**
     * Maps Entity to DTO.
     */
    private EmployeePayRollDTO mapToDTO(EmployeePayRoll employee) {
        return EmployeePayRollDTO.builder()
                .name(employee.getName())
                .salary(employee.getSalary())
                .department(employee.getDepartment())
                .build();
    }
}
