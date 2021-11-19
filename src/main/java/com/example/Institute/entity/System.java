package com.example.Institute.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class System {
    private List<Content> contents = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
}
