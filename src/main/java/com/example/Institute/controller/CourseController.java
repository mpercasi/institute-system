package com.example.Institute.controller;

import com.example.Institute.entity.Course;
import com.example.Institute.entity.CourseDetail;
import com.example.Institute.entity.Student;
import com.example.Institute.exceptions.NonExistentStudentException;
import com.example.Institute.exceptions.StudentDuplicateException;
import com.example.Institute.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private SystemService system;

    @GetMapping
    public List<Course> getCourses() throws NonExistentStudentException {
        List<Course> courses = system.getAllCourses();
        if (courses.isEmpty()){
            throw new NonExistentStudentException();
        }
        return courses;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable int id) throws NonExistentStudentException {
        Optional<Course> course = system.searchCourseById(id);
        if(course.isEmpty()){
            throw new NonExistentStudentException();
        }
        return ResponseEntity.ok(course.get());
    }

    @PostMapping
    public ResponseEntity createCourse(@RequestBody Course course) throws StudentDuplicateException {
        system.registerCourse(course);
        return ResponseEntity.ok("Course registered successfully!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCourse(@PathVariable int id) throws NonExistentStudentException{
        Optional<Course> course = system.searchCourseById(id);
        if(course.isEmpty()){
            throw new NonExistentStudentException();
        }
        system.deleteCourse(course.get());
        return ResponseEntity.ok("Course deleted successfully!");
    }


}
