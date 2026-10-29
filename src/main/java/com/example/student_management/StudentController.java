package com.example.student_management;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @Operation(
            summary = "Get all students",
            description = "Retrieves all students stored in the database."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Students retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @Operation(
            summary = "Get student by ID",
            description = "Retrieves a student using their unique ID."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Student found successfully"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @Operation(
            summary = "Search student by email",
            description = "Finds a student using their registered email address."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Student found successfully"),
            @ApiResponse(responseCode = "404", description = "No student found with that email")
    })
    @GetMapping("/students/search")
    public Student getStudentByEmail(@RequestParam String email){
        return studentService.getStudentByEmail(email);
    }



    @Operation(
            summary = "Create a student",
            description = "Registers a new student with a name and email address."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Student created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid student request"),
            @ApiResponse(responseCode = "409", description = "Email already exists")
    })
    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public Student addStudent(@Valid @RequestBody StudentRequest request){
        Student student = new Student(request.getName(), request.getEmail());
        return studentService.addStudent(student);
    }

    @Operation(
            summary = "Update a student",
            description = "Updates the name and email of an existing student using their ID."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Student updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid student request"),
            @ApiResponse(responseCode = "404", description = "Student not found"),
            @ApiResponse(responseCode = "409", description = "Email already belongs to another student")
    })
    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable int id,@Valid @RequestBody StudentRequest request){
        Student updatedStudent= new Student(request.getName(), request.getEmail());
        return studentService.updateStudent(id, updatedStudent);
    }

    @Operation(
            summary = "Delete a student",
            description = "Deletes a student using their unique ID."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Student deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);

        return ResponseEntity.noContent().build();
    }
}
