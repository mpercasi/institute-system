package com.example.Institute.controller;

import com.example.Institute.entity.AcademicRecord;
import com.example.Institute.entity.Student;
import com.example.Institute.entity.StudentRecord;
import com.example.Institute.exceptions.NonExistentStudentException;
import com.example.Institute.exceptions.StudentDuplicateException;
import com.example.Institute.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private SystemService system;

    @GetMapping
    public List<Student> getStudents() throws NonExistentStudentException{
        List<Student> students = system.getAllStudents();
        if (students.isEmpty()){
            throw new NonExistentStudentException();
        }
        return students;
    }

    @GetMapping("/{dni}")
    public ResponseEntity<Student> getStudent(@PathVariable int dni) throws NonExistentStudentException {
        Optional<Student> students = system.searchStudent(dni);
        if(students.isEmpty()){
            throw new NonExistentStudentException();
        }
        return ResponseEntity.ok(students.get());
    }

    @PostMapping
    public ResponseEntity createStudent(@RequestBody Student student) throws StudentDuplicateException {
        System.out.println("Llegó una peticion");
        Optional<Student> students = system.searchStudent(student.getDni());
        if(!students.isEmpty()){
            throw new StudentDuplicateException();
        }
        system.registerStudent(student);
        return ResponseEntity.ok("Student registered successfully!");
    }

    @PutMapping
    public ResponseEntity updateStudent(@RequestBody Student student) throws NonExistentStudentException{
        if (system.searchStudent(student.getDni()).isEmpty()){
            throw new NonExistentStudentException();
        }
        system.uptateStudent(student);
        return ResponseEntity.ok("Student updated successfully!");
    }

    //@DeleteMapping("delete/{dni}")
    @DeleteMapping
    public ResponseEntity deleteStudent(@RequestBody Student student) throws NonExistentStudentException{
        if(system.searchStudent(student.getDni()).isEmpty()){
            throw new NonExistentStudentException();
        }
        system.deleteStudent(student);
        return ResponseEntity.ok("User deleted successfully!");
    }

    @GetMapping("records/{dni}")
    public ResponseEntity getStudentRecord(@PathVariable("dni") Integer dni) throws NonExistentStudentException {
        Optional<Student> students = system.searchStudent(dni);
        if(students.isEmpty()){
            throw new NonExistentStudentException();
        }
        return ResponseEntity.ok(students.get().getAcademicRecords());
    }

//    @GetMapping("records/{dni}")
//    public List<StudentRecord> getStudentRecord(@PathVariable("dni") Integer dni) throws NonExistentStudentException {
//        Optional<Student> students = system.searchStudent(dni);
//        if(students.isEmpty()){
//            throw new NonExistentStudentException();
//        }
//        return system.getStudentRecord(dni);
//    }
}
