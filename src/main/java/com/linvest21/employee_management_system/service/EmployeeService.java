package com.linvest21.employee_management_system.service;

import com.linvest21.employee_management_system.model.Employee;
import com.linvest21.employee_management_system.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    // private final EmployeeRepository employeeRepository;: 
    // This declares a final variable employeeRepository that will hold the reference to the repository instance.
    private final EmployeeRepository employeeRepository;

    // Constructor Injection: The EmployeeService class is using constructor
    // injection to receive an instance of EmployeeRepository. This is a common 
    // practice in Spring, where dependencies are injected via the constructor. 
    // It makes the class easier to test because you can provide mock dependencies during testing.
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
