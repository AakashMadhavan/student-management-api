# Student Management REST API

A RESTful API built using Java and Spring Boot to manage student records. The application supports CRUD operations, request validation, duplicate email prevention, and structured error responses.

## Features

- Create a student
- Retrieve all students
- Retrieve a student by ID
- Search students by email
- Update student details
- Delete a student
- Validate request data using Jakarta Bean Validation
- Prevent duplicate email addresses
- Handle exceptions with consistent JSON responses
- Document and explore API endpoints using Swagger UI
- Test service logic using JUnit and Mockito

## Tech Stack

- **Language:** Java
- **Framework:** Spring Boot
- **Database:** MySQL
- **Persistence:** Spring Data JPA and Hibernate
- **Build Tool:** Maven
- **API Testing:** Postman and Swagger UI
- **Testing:** JUnit and Mockito
- **Validation:** Jakarta Bean Validation

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/students` | Retrieve all students |
| GET | `/students/{id}` | Retrieve a student by ID |
| GET | `/students/search?email={email}` | Search by email |
| POST | `/students` | Create a student |
| PUT | `/students/{id}` | Update a student |
| DELETE | `/students/{id}` | Delete a student |

## Example Request

Create a student using `POST /students`:

```json
{
  "name": "Priya",
  "email": "priya@example.com"
}
```

A successful request returns `201 Created`.

## HTTP Status Codes

| Status Code | Description |
|---|---|
| `200 OK` | Request completed successfully |
| `201 Created` | Student created successfully |
| `204 No Content` | Student deleted successfully |
| `400 Bad Request` | Request validation failed |
| `404 Not Found` | Student does not exist |
| `409 Conflict` | Email address already exists |

## Getting Started

### Prerequisites

- Java JDK 17 or later
- MySQL
- Git

### 1. Clone the repository

```bash
git clone https://github.com/AakashMadhavan/student-management-api.git
cd student-management-api
```

### 2. Create the database

Open MySQL and execute:

```sql
CREATE DATABASE student_db;
```

### 3. Configure database credentials

The application reads database credentials from environment variables.

Configure the following variables:

- `DB_USERNAME` — Your MySQL username
- `DB_PASSWORD` — Your MySQL password

For Windows PowerShell:

```powershell
$env:DB_USERNAME = "your_mysql_username"
$env:DB_PASSWORD = "your_mysql_password"
```

For macOS/Linux:

```bash
export DB_USERNAME="your_mysql_username"
export DB_PASSWORD="your_mysql_password"
```

Keep your database credentials private. Never commit passwords or secrets to GitHub.

### 4. Run the application

For Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

For macOS/Linux:

```bash
./mvnw spring-boot:run
```

The application starts at:

`http://localhost:8080`

## Swagger API Documentation

After starting the application, open:

[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

You can explore endpoints, provide request parameters, submit JSON bodies, and inspect API responses.

## Testing

The project includes an application context test and service unit tests using JUnit and Mockito.

Run the tests from IntelliJ IDEA or execute:

**Windows:**

```powershell
.\mvnw.cmd test
```

**macOS/Linux:**

```bash
./mvnw test
```

## Future Improvements

- Add pagination and sorting
- Add authentication and authorization
- Add integration tests for REST endpoints
- Add a frontend using React or another web framework

## Author

Developed as a Java and Spring Boot learning project.

