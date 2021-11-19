package com.example.Institute.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
@Table(name = "Estudiantes")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer dni;
    private String name;
    private String surname;
    private String address;
    private String mail;

//    @OneToOne(cascade = {CascadeType.ALL})
    @OneToMany(cascade = {CascadeType.ALL})
    @Column(name="Expedientes")
    private List<AcademicRecord> academicRecords = new ArrayList<>();

    public Student() {
    }

    public Student(Integer dni, String name, String surname, String address, String mail, List<AcademicRecord> academicRecords) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.mail = mail;
        this.academicRecords = academicRecords;
    }

    public Student(Integer dni, String name, String surname, String address, String mail) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.mail = mail;
    }
}
