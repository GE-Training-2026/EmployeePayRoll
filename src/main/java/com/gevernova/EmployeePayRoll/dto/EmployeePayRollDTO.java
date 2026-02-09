package com.gevernova.EmployeePayRoll.dto;

import lombok.*;

/**
 * DTO used to accept request data from client
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class EmployeePayRollDTO {
    private String name;
    private double salary;
    private String department;
}
