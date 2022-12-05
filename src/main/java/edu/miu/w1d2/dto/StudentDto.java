package edu.miu.w1d2.dto;

import edu.miu.w1d2.entity.Course;
import lombok.Data;

import java.util.List;

@Data
public class StudentDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<CourseDto> coursesTaken;
}
