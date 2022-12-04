package com.lab.restlab.dto;

import com.lab.restlab.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
//    private List<Course> courseList;
}
