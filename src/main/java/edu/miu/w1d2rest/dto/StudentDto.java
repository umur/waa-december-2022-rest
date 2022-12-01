package edu.miu.w1d2rest.dto;

import lombok.Data;

@Data
public class StudentDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
}
