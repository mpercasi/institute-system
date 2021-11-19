package com.example.Institute.repository;

import com.example.Institute.entity.Course;
import com.example.Institute.entity.CourseDetail;
import com.example.Institute.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CourseRepository extends CrudRepository<Course, Integer> {

    @Query(value = "SELECT * FROM CURSOS", nativeQuery = true)
    List<Course> getAllCourses();

    //Sirve ------------
    //@Query(value = "SELECT new com.example.Institute.entity.CourseDetail(c.name, c.description, c.duration) FROM Content c")
    //List<CourseDetail> getAllCourses();

}
