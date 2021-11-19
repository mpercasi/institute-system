package com.example.Institute.service;

import com.example.Institute.entity.Student;
import com.example.Institute.entity.StudentRecord;
import com.example.Institute.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SystemService {
    @Autowired
    private StudentRepository studentRepository;

    //Students ----------------------------------------
    public Optional<Student> searchStudent(Integer dni) {
        return studentRepository.getStudentByDni(dni);
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }

    public void uptateStudent(Student student) {
        studentRepository.updateStudent(student.getDni(), student.getName(), student.getSurname(), student.getAddress(), student.getMail());
    }

    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }

    public List<StudentRecord> getStudentRecord(int dni) {
        return studentRepository.getStudentRecord(dni);
    }
}
