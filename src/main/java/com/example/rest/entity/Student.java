package com.example.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
// id, firstName, lastName, email, major, and coursesTaken
public class Student {

    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String major;

    private List<Course> courseTaken;

}
