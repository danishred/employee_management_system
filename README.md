# Employee Management System

## Overview
The Employee Management System (EMS) is a Spring Boot application designed to manage employee data. It provides functionalities for creating, fetching, customise fetching, updating, and deleting employee records. The application uses PostgreSQL as the database and is secured with Spring Security. It also includes validation and error handling mechanisms to ensure data integrity and a robust user experience. It has flyway implemented
for schema migration jobs. 


## Features

- **CRUD Operations**: Create, Retrieve, Update, and Delete employee records.
- **Validation**: Enforces constraints on employee data such as name, email, salary, and department.
- **Error Handling**: Provides meaningful error messages for invalid input and resource not found scenarios.
- **Pagination & Sorting**: Supports pagination and sorting for retrieving employee records.
- **Security**: Secured with Spring Security for API protection.
- **Dockerization**: The application can be dockerized for ease of deployment.

## Prerequisites

- **IDE**: I used VS Code but any would work, like IntelliJ or Eclipse.
- **Java 21**: Ensure you have Java 21 installed.
- **PostgreSQL**: The application uses PostgreSQL 16. Docker is used to run PostgreSQL, but it can also be installed locally.
- **Maven**: Apache Maven is used for building the project.
- **Docker** (Optional): For containerizing the application.

## Setup Instructions

1. **Clone the Repository**

    ```bash
    git clone <repository-url>
    cd employee_management_system
    ```
2. Install Docker Desktop if not already present: https://docs.docker.com/desktop/

3. Run Docker Desktop.

4. In terminal write command : "docker compose up -d"
    - The postgres container would now be visible in the container application)
    - That is all needed to setup your database

6. Run the SpringBoot server: 
    - location: employee_management_system\src\main\java\com\linvest21\employee_management_system
    - filename: EmployeeManagementSystemApplication.java

6. Accessing API endpoints
    - I have also shared all the API endpoints collection in the repository with the filename: "EmployeeManagementSystem.postman_collection.json".
      You can import it in your Postman and perform further testing.
    - Also you can access API documentations from Swagger through: http://localhost:8080/swagger-ui/index.html#/
