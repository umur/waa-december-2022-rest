package edu.miu.restdemo.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private int id;

    private String firstName;
    private String lastName;
    private String email;
    private String major;

    private List<Course> coursesTaken;
//
    public Student (int id, String firstName, String lastName, String email, String major){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
    }
//
//    public Student (){}

}
