package com.lab.restlab.entity;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    @Nullable
    private List<Course> courseList;

    public Student(int id, String firstName, String lastName, String email, String major) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.courseList = new ArrayList<>();
    }
}