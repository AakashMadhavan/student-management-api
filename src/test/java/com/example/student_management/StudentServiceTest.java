package com.example.student_management;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.springframework.web.server.ResponseStatusException;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentServiceTest {

    @Test
    void getStudentByIdReturnsStudentWhenFound() {

        // 1. Create a fake repository
        StudentRepository repository = mock(StudentRepository.class);

        // 2. Give the fake repository to the service
        StudentService service = new StudentService(repository);

        // 3. Create sample student data
        Student expected = new Student(
                1, "Arun", "arun@example.com"
        );

        // 4. Tell the fake repository what to return
        when(repository.findById(1))
                .thenReturn(Optional.of(expected));

        // 5. Call the method we want to test
        Student actual = service.getStudentById(1);

        // 6. Check the result
        assertEquals(1, actual.getId());
        assertEquals("Arun", actual.getName());
        assertEquals("arun@example.com", actual.getEmail());
    }


    @Test
    void getStudentByIdThrows404WhenStudentNotFound() {

        StudentRepository repository = mock(StudentRepository.class);
        StudentService service = new StudentService(repository);

        // Tell the fake repository that ID 999 does not exist
        when(repository.findById(999))
                .thenReturn(Optional.empty());

        // Verify that the service throws an exception
        ResponseStatusException exception = assertThrows(
                ResponseStatusException.class,
                () -> service.getStudentById(999)
        );

        // Verify that the exception contains HTTP 404
        assertEquals(404, exception.getStatusCode().value());
    }


    @Test
    void addStudentThrows409WhenEmailAlreadyExists() {

        // 1. Create a fake repository
        StudentRepository repository = mock(StudentRepository.class);

        // 2. Create the service
        StudentService service = new StudentService(repository);

        // 3. Tell Mockito that this email already exists
        when(repository.existsByEmail("arun@example.com"))
                .thenReturn(true);

        // 4. Create a student with the duplicate email
        Student student = new Student(
                "Arun",
                "arun@example.com"
        );

        // 5. Verify that adding this student throws an exception
        ResponseStatusException exception = assertThrows(
                ResponseStatusException.class,
                () -> service.addStudent(student)
        );

        // 6. Verify that the status is 409 Conflict
        assertEquals(409, exception.getStatusCode().value());
    }


    @Test
    void addStudentSavesStudentWhenEmailIsNew() {

        StudentRepository repository = mock(StudentRepository.class);
        StudentService service = new StudentService(repository);

        Student student = new Student(
                "Priya",
                "priya@example.com"
        );

        // The email is not already registered
        when(repository.existsByEmail("priya@example.com"))
                .thenReturn(false);

        // Simulate saving the student
        when(repository.save(student)).thenReturn(student);

        Student actual = service.addStudent(student);

        assertEquals("Priya", actual.getName());
        assertEquals("priya@example.com", actual.getEmail());
    }

}
