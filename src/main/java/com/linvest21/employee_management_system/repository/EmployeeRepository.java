package com.linvest21.employee_management_system.repository;

import com.linvest21.employee_management_system.model.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>    {
    // self generated methods extended by jpa, you can add them yourself as well
}