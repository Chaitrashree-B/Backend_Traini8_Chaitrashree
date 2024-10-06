# Backend MVP for Traini8 - Training Center Registry

This project is an MVP backend for the Traini8 startup, built with **Spring Boot**. It includes APIs for registering training centers and fetching a list of saved centers.

## Requirements

- **Java 17** or higher
- **Maven** (version 3.x)
- **Spring Boot** (version 3.x)
- **MySQL** (or H2 for in-memory database)
- **Postman** or **cURL** for API testing (optional)
  
## Project Structure

- `src/main/java`: Contains the main application code.
- `src/main/resources`: Configuration files such as `application.properties`.
- `src/test/java`: Unit and integration tests.
- `pom.xml`: Maven build file, managing dependencies.

## Setup InstructionsDownload and unzip the project.
Navigate to the project directory.
1.Configure the Database 
Option 1: MySQL Setup Install MySQL and start the MySQL service.Create a database:
1 CREATE DATABASE traini8_db; 
2 Update src/main/resources/application.properties with your MySQL connection details
spring.datasource.url=jdbc:mysql://localhost:3306/traini8_db 
spring.datasource.username=root 
spring.datasource.password=your_password 
spring.jpa.hibernate.ddl-auto=update 
Option 2: H2 In-Memory Database If you prefer to use the H2 in-memory database, simply update application.properties like this:
spring.datasource.url=jdbc:h2:mem:traini8_db spring.datasource.driverClassName=org.h2.Driver 
spring.datasource.username=sa 
spring.datasource.password= 
spring.jpa.hibernate.ddl-auto=update 
spring.h2.console.enabled=true
3. Build and Run the Application
 1.Ensure Maven and Java 17+ are installed on your machine.
 2.To build the project, run:
   mvn clean install
 3.To run the application:
   mvn spring-boot:run
 4. The application will start on http://localhost:8080.
4. Testing the APIs
POST API to Create a Training Center
URL: POST http://localhost:8080/api/training-centers
Payload (JSON):
{
  "centerName": "ABC Training Center",
  "centerCode": "123456ABCDEF",
  "address": {
    "detailedAddress": "123 Main St",
    "city": "Bangalore",
    "state": "Karnataka",
    "pincode": "560001"
  },
  "studentCapacity": 100,
  "coursesOffered": ["Java", "Spring Boot"],
  "contactEmail": "abc@training.com",
  "contactPhone": "9876543210"
}
GET API to Fetch All Training Centers
 ->URL: GET http://localhost:8080/api/training-centers
 ->Response (if records exist):
   [
  {
    "centerName": "ABC Training Center",
    "centerCode": "123456ABCDEF",
    "address": {
      "detailedAddress": "123 Main St",
      "city": "Bangalore",
      "state": "Karnataka",
      "pincode": "560001"
    },
    "studentCapacity": 100,
    "coursesOffered": ["Java", "Spring Boot"],
    "createdOn": 1633072800,
    "contactEmail": "abc@training.com",
    "contactPhone": "9876543210"
  }
]
Test Failure Scenarios
Missing centerName, centerCode, or incorrect field sizes will trigger validation errors with detailed messages.
5. Running Tests
The project includes unit tests for the APIs in src/test/java.
 1. To run tests:
  mvn test
 2. A sample test is available in TrainingCenterControllerTest.java:
6. Exception Handling
Errors such as validation failures or incorrect inputs are handled using custom exception handlers to provide clear error messages.
