package com.linvest21.employee_management_system.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.linvest21.employee_management_system.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateEmployee_InvalidInput() throws Exception {
        Employee employee = new Employee();
        employee.setName("John Doe");
        employee.setEmail("invalid-email");
        employee.setSalary(-50000.0);  // Invalid salary
        employee.setDepartment("");    // Invalid department

        mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isBadRequest());  // Expecting 400 Bad Request
    }
}
