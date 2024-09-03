package com.linvest21.employee_management_system.service;


import com.linvest21.employee_management_system.exception.ResourceNotFoundException;
import com.linvest21.employee_management_system.model.Employee;
import com.linvest21.employee_management_system.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    void testCreateEmployee() {
        Employee employee = new Employee();
        employee.setName("John Doe");
        employee.setEmail("john@example.com");
        employee.setSalary(50000.0);
        employee.setDepartment("IT");

        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        Employee savedEmployee = employeeService.save(employee);

        assertNotNull(savedEmployee);
        assertEquals("John Doe", savedEmployee.getName());
        assertEquals("john@example.com", savedEmployee.getEmail());
    }

    @Test
    void testGetEmployeeById() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("John Doe");

        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        Employee foundEmployee = employeeService.findById(1L);

        assertNotNull(foundEmployee);
        assertEquals(1L, foundEmployee.getId());
        assertEquals("John Doe", foundEmployee.getName());
    }

    @Test
    void testGetEmployeeById_NotFound() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            employeeService.findById(1L);
        });
    }
}
