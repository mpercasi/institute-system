package com.example.Institute.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CourseDetail {
    private String name;
    private String description;
    private Integer duration;

    public CourseDetail() {
    }

    public CourseDetail(String name, String description, Integer duration) {
        this.name = name;
        this.description = description;
        this.duration = duration;
    }
}
