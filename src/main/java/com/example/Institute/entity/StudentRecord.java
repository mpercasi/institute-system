package com.example.Institute.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

@Getter @Setter
public class StudentRecord {
    private String name;
    private Collection academicRecords = new ArrayList<>();

    public StudentRecord() {
    }

    public StudentRecord(String name, List<AcademicRecord> academicRecords) {
        this.name = name;
        this.academicRecords = academicRecords;
    }

    public StudentRecord(String name, Collection academicRecords) {
        this.name = name;
        this.academicRecords = academicRecords;
    }

    public StudentRecord(String name) {
        this.name = name;
    }
}
