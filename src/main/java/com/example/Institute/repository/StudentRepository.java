package com.example.Institute.repository;

import com.example.Institute.entity.Student;
import com.example.Institute.entity.StudentRecord;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface StudentRepository extends CrudRepository<Student, Integer> {

    @Query(value = "SELECT * FROM estudiantes", nativeQuery = true)
    List<Student> getAllStudents();

    @Query(value = "SELECT * FROM estudiantes WHERE dni=:dni", nativeQuery = true)
    Optional<Student> getStudentByDni(Integer dni);

    @Modifying
    @Query(value = "UPDATE estudiantes SET name=:name, surname=:surname, address=:address, mail=:mail WHERE dni=:dni", nativeQuery = true)
    void updateStudent(int dni, String name, String surname, String address, String mail);

    //Students records
    //@Query(value = "SELECT new com.example.Institute.entity.StudentRecord(s.name, s.academicRecords) FROM Student s WHERE s.dni=:dni")
    @Query(value = "SELECT new com.example.Institute.entity.StudentRecord(s.name, s.academicRecords) FROM Student s JOIN s.academicRecords WHERE s.dni=:dni")
    List<StudentRecord> getStudentRecord(Integer dni);
}
