package com.linvest21.employee_management_system.service;

import com.linvest21.employee_management_system.repository.EmployeeRepository;
import com.linvest21.employee_management_system.exception.ResourceNotFoundException;
import com.linvest21.employee_management_system.model.Employee;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import java.math.BigDecimal;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

// includes Unit tests (using both Junit and Mockito)
@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    //  Pass Test for create employee
    @Test
    void testCreateEmployee() {
        Employee employee = new Employee();
        employee.setName("edward kenway");
        employee.setEmail("anything@example.com");
        employee.setSalary(BigDecimal.valueOf(45000.0));
        employee.setDepartment("HR");

        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        Employee savedEmployee = employeeService.save(employee);

        assertNotNull(savedEmployee);
        assertEquals("edward kenway", savedEmployee.getName());
        assertEquals("anything@example.com", savedEmployee.getEmail());
    }

    // Pass Test for get Employee id
    @Test
    void testGetEmployeeById() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("duncan walpole");

        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        Employee foundEmployee = employeeService.findById(1L);

        assertNotNull(foundEmployee);
        assertEquals(1L, foundEmployee.getId());
        assertEquals("duncan walpole", foundEmployee.getName());
    }

    // Fail case for test Employee
    @Test
    void testCreateEmployee_Failed() {
        Employee employee = new Employee();
        employee.setName("ezio auditore");
        employee.setEmail("auditore@example.com");
        employee.setSalary(BigDecimal.valueOf(50000.0));
        employee.setDepartment("ASSASSINATION");

        when(employeeRepository.save(any(Employee.class))).thenThrow(new RuntimeException("Database error"));

        assertThrows(RuntimeException.class, () -> {
            employeeService.save(employee);
        });
    }

    // fail case for get employee by id
    @Test
    void testGetEmployeeById_NotFound() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            employeeService.findById(1L);
        });
    }
}
