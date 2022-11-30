package edu.miu.lab2.model.dto;

import edu.miu.lab2.model.Course;
import lombok.Data;

import java.util.List;

@Data
public class StudentDTO {
    private int id;
    private String firstName;
    private String lastName;
    private List<Course> coursesTaken;
}
