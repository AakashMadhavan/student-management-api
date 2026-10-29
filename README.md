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
| POST | `/students` | Create a student |
| PUT | `/students/{id}` | Update a student |
| DELETE | `/students/{id}` | Delete a student |
| GET | `/students/search?email={email}` | Search by email |

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

- `200 OK` — Request completed successfully
- `201 Created` — Student created successfully
- `204 No Content` — Student deleted successfully
- `400 Bad Request` — Request validation failed
- `404 Not Found` — Student does not exist
- `409 Conflict` — Email address already exists

## Configuration

1. Install a compatible JDK, Maven, and MySQL.
2. Create a MySQL database named `student_db`.
3. Configure your database URL, username, and password in `src/main/resources/application.properties`.
4. Keep database credentials private. Do not commit passwords or secrets to GitHub.
5. Reload the Maven project and run the Spring Boot application.

## Swagger API Documentation

After starting the application, open:

`http://localhost:8080/swagger-ui/index.html`

You can explore endpoints, provide request parameters, submit JSON bodies, and inspect API responses.

## Testing

The project includes an application context test and service unit tests using JUnit and Mockito.

Run the tests from IntelliJ IDEA or execute:

```bash
mvn test
```

## Future Improvements

- Add pagination and sorting
- Add authentication and authorization
- Add integration tests for REST endpoints
- Add a frontend using React or another web framework

## Author

Developed as a Java and Spring Boot learning project.