package edu.miu.w1d2.entity;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private boolean deleteFlag;
    private List<Course> coursesTaken;


    public Student(int id, String firstName, String lastName, String email, String major, boolean deleteFlag) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.deleteFlag = deleteFlag;
    }
}
