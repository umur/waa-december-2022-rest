package edu.miu.lab2_assignment.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class Student {
    private int id;
    private  String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<Course> coursesTaken;

    private boolean deleted;

    public Student(int id, String firstName, String lastName, String email, String major, List<Course>coursesTaken){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.major=major;
        this.coursesTaken=coursesTaken;


    }


    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}
