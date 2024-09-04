package com.linvest21.employee_management_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;
import java.math.BigDecimal;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;
import jakarta.persistence.Column;

@Entity
@Table(name = "employees")
public class Employee {

    // Employee entity annotated with validators
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 255, message = "Name should not be more than 255 characters")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Salary is mandatory")
    @Positive(message = "Salary must be positive")
    @Digits(integer = 8, fraction = 2, message = "Salary must be a number with max 8 digits and 2 decimals")
    @Column(precision = 10, scale = 2) // Define precision and scale
    private BigDecimal salary;

    @NotBlank(message = "Department is mandatory")
    private String department;


    
    // Getters and Setters (for fetching and adding values to private variables)


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // For creating instance without value
    public Employee() {
    }



    // for creating instances with initial values.
    public Employee(Long id, @NotBlank(message = "Name is mandatory") String name,
            @Email(message = "Email should be valid") @NotBlank(message = "Email is mandatory") String email,
            @Positive(message = "Salary must be positive") BigDecimal salary, String department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.department = department;
    }

    //Ensures that equal objects have the same hash code, crucial for using entities in collections that rely on hashing (no use currently but added anyway)
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((salary == null) ? 0 : salary.hashCode());
        result = prime * result + ((department == null) ? 0 : department.hashCode());
        return result;
    }

    // equality check based on the id field, entities are considered equal if they have the same ID.
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (salary == null) {
            if (other.salary != null)
                return false;
        } else if (!salary.equals(other.salary))
            return false;
        if (department == null) {
            if (other.department != null)
                return false;
        } else if (!department.equals(other.department))
            return false;
        return true;
    }
}