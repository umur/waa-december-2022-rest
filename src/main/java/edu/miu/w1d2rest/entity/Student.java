package edu.miu.w1d2rest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<Course> coursesTaken;
    private boolean deleted;

    public Student(int id, String firstName, String lastName, String email, String major, List<Course> coursesTaken){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.coursesTaken = coursesTaken;
    }

    public List<Course> getNotDeletedCourseTaken(){
        return this.coursesTaken.stream()
                .filter(course -> !course.isDeleted())
                .collect(Collectors.toList());
    }
}
