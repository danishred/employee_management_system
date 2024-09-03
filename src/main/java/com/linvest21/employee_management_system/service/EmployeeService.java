package com.linvest21.employee_management_system.service;

import com.linvest21.employee_management_system.exception.ResourceNotFoundException;
import com.linvest21.employee_management_system.model.Employee;
import com.linvest21.employee_management_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

  public Employee save(Employee employee) {
        try {
            return employeeRepository.save(employee);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save employee due to unexpected error", e);
        }
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + id));
    }

    public List<Employee> findAll() {
    try {
        return employeeRepository.findAll();
    } catch (Exception e) {
        throw new RuntimeException("Failed to access employee list", e);
    }
        
    }

    public Employee update(Long id, Employee employeeDetails) {
        return employeeRepository.findById(id)
            .map(employee -> {
                employee.setName(employeeDetails.getName());
                employee.setEmail(employeeDetails.getEmail());
                employee.setSalary(employeeDetails.getSalary());
                employee.setDepartment(employeeDetails.getDepartment());
                return employeeRepository.save(employee);
            })
            .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + id));
    }

    public boolean delete(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Employee not found with ID: " + id);
        }
        employeeRepository.deleteById(id);
        return true;
    }
}
