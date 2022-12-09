package edu.miu.lab2.entity;

import lombok.Data;

import java.util.List;

@Data
public class Student {

    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String major;

    private List<Course> courses;

}
