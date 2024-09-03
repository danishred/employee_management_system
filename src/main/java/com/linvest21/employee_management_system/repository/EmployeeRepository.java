package com.linvest21.employee_management_system.repository;

import com.linvest21.employee_management_system.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Methods are self generated, you can add them yourself as well
}

