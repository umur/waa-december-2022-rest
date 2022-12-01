package com.example.lab2.dto;

import com.example.lab2.entity.Course;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class StudentBasicDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<Course> coursesTaken;

}
