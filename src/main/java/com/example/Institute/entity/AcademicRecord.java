package com.example.Institute.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
@Table(name = "Expedientes")
public class AcademicRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date enrollmentDate;
    private Integer score;
    private Date endDate;

    @OneToMany(cascade = {CascadeType.ALL})
    @Column(name="Cursos")
    private List<Course> courses = new ArrayList<>();

    public AcademicRecord() {
    }

    public AcademicRecord(Date enrollmentDate, Integer score, Date endDate, List<Course> courses) {
        this.enrollmentDate = enrollmentDate;
        this.score = score;
        this.endDate = endDate;
        this.courses = courses;
    }
}
