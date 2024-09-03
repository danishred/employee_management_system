package com.linvest21.employee_management_system.service;

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
        return employeeRepository.save(employee);
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
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
            .orElse(null);
    }

    public boolean delete(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
