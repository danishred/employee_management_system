package com.linvest21.employee_management_system.service;

import com.linvest21.employee_management_system.exception.InvalidRequestParameterException;
import com.linvest21.employee_management_system.exception.ResourceNotFoundException;
import com.linvest21.employee_management_system.model.Employee;
import com.linvest21.employee_management_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.util.List;

// Service logic for Employee
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // save employee in DV
    public Employee save(Employee employee) {
        try {
            return employeeRepository.save(employee);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save employee due to unexpected error", e);
        }
    }

    // Find employee by Id
    public Employee findById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + id));
    }

    // list all employee
    public List<Employee> findAll() {
        try {
            return employeeRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Failed to access employee list", e);
        }

    }

    // update details of Employee
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

    // Delete an employee
    public boolean delete(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Employee not found with ID: " + id);
        }
        employeeRepository.deleteById(id);
        return true;
    }

    // Customise employee list fetch
    public Page<Employee> findAllEmployees(int page, int size, String sortBy, String sortDir) {
            validatePageAndSize(page, size);
            validateSortBy(sortBy);
            validateSortDir(sortDir);
            Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                    : Sort.by(sortBy).descending();
            Pageable pageable = PageRequest.of(page, size, sort);
            return employeeRepository.findAll(pageable);
    }

    // whether got right pagea and size parameter or not
    private void validatePageAndSize(int page, int size) {
        if (page < 0) {
            throw new InvalidRequestParameterException("Page must be a non-negative integer.");
        }
        if (size < 1) {
            throw new InvalidRequestParameterException("Size must be a positive integer.");
        }
    }

    // whether got right sortby parameter or not
    private void validateSortBy(String sortBy) {
        // List of valid fields
        List<String> validSortFields = Arrays.asList("id", "name", "email", "salary");
        if (!validSortFields.contains(sortBy)) {
            throw new InvalidRequestParameterException("Invalid sort field: " + sortBy);
        }
    }

    // whether got right sortdir parameter or not
    private void validateSortDir(String sortDir) {
        if (!sortDir.equalsIgnoreCase("asc") && !sortDir.equalsIgnoreCase("desc")) {
            throw new InvalidRequestParameterException("Invalid sort direction: " + sortDir);
        }
    }

}