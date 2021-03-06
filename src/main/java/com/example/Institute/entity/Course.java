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
@Table(name="Cursos")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

//    @OneToMany(cascade = {CascadeType.ALL})
    @ManyToMany(cascade = {CascadeType.ALL})
//    @Column(name="Contenidos")
    private List<Content> contents = new ArrayList<>();

    public Course() {
    }

    public Course(List<Content> contents) {
        this.contents = contents;
    }
}
