package com.example.Institute.controller;

import com.example.Institute.entity.Course;
import com.example.Institute.entity.CourseDetail;
import com.example.Institute.exceptions.NonExistentStudentException;
import com.example.Institute.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
