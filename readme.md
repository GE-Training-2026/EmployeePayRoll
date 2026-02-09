# Employee Payroll Management System

A RESTful Employee Payroll Management System built using Spring Boot.  
This application provides CRUD operations for managing employee payroll data with a clean layered architecture.

---

## Features

- Create, read, update, and delete employee records
- Layered architecture (Controller, Service, Repository)
- DTO-based request/response handling
- Global exception handling
- Logging with SLF4J
- Spring Data JPA integration
- PostgreSQL database support

---

## Tech Stack

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- PostgreSQL
- Lombok
- Maven

---

## Project Structure

```aiignore
EmployeePayRoll
├── src/main/java/com/gevernova/EmployeePayRoll
│ ├── controllers
│ │ └── EmployeePayRollControllers.java
│ ├── dto
│ │ └── EmployeePayRollDTO.java
│ ├── entity
│ │ └── EmployeePayRoll.java
│ ├── exceptions
│ │ ├── GlobalException.java
│ │ └── IDNotFound.java
│ ├── repository
│ │ └── EmployeePayRollRepository.java
│ ├── services
│ │ ├── EmployeePayRollService.java
│ │ └── EmployeePayRollServiceImplementation.java
│ └── EmployeePayRollApplication.java
├── src/main/resources
│ └── application.properties
├── pom.xml
└── README.md
```


---

## Prerequisites

- Java 17 or higher
- Maven
- PostgreSQL
- Git

---

## Database Configuration

Create database in PostgreSQL:

```sql
CREATE DATABASE employee_payroll;
```

## Update application.properties:
```aiignore
spring.application.name=EmployeePayRoll

spring.datasource.url=jdbc:postgresql://localhost:5432/employee_payroll
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.format_sql=true

```

## Running the Application

- Clone the repository:
```aiignore
git clone <your-repository-url>
cd EmployeePayRoll

```

- Run the application:
```aiignore
./mvnw spring-boot:run

```

- Application will start at:
````aiignore
http://localhost:8080
````

## API Endpoints
### Employees

- POST /api/employees

- GET /api/employees

- GET /api/employees/{id}

- PUT /api/employees/{id}

- DELETE /api/employees/{id}


## Sample Request

### Create Employee

POST /api/employees

```json
{
  "name": "John Doe",
  "salary": 50000,
  "department": "Engineering"
}
``` 
## Error Handling

- Custom exception for ID not found

- Global exception handler using @ControllerAdvice

- Proper HTTP status codes returned

## Logging

- SLF4J used for application logging

- Logs important operations such as:

- Create employee

- Update employee

- Fetch employee(s)

- Delete employee