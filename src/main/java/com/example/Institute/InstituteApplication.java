package com.example.Institute;

import com.example.Institute.entity.AcademicRecord;
import com.example.Institute.entity.Content;
import com.example.Institute.entity.Course;
import com.example.Institute.entity.Student;
import com.example.Institute.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class InstituteApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstituteApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner demo(StudentRepository studentRepository){
//		return args -> {
//
////			Content cont = new Content("Algebra", "Curso basico", 10);
////			Course c = new Course(List.of(cont));
////			AcademicRecord ar = new AcademicRecord(new Date(), 0, new Date(), List.of(c));
////
////			Student s = new Student(12345, "Marcos", "Perez", "Matamoris 11", "marcoscbvb@gmail.com" ,List.of(ar));
////			studentRepository.save(s);
//		};
//	}

}
