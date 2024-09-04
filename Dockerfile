# Use a base image with Java
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY employee_management_system-0.0.1-SNAPSHOT.jar /app/employee_management_system.jar

# Expose the port on which your application will run
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app/employee_management_system.jar"]
