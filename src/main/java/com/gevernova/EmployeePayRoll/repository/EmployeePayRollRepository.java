package com.gevernova.EmployeePayRoll.repository;

import com.gevernova.EmployeePayRoll.Entity.EmployeePayRoll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository layer for database operations
 */
@Repository
public interface EmployeePayRollRepository extends JpaRepository<EmployeePayRoll, Long> {
    // CRUD operations provided by JpaRepository
}

