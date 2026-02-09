package com.gevernova.EmployeePayRoll.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee_payroll")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeePayRoll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private Double salary;

    @Column(nullable = false, length = 50)
    private String department;
}
