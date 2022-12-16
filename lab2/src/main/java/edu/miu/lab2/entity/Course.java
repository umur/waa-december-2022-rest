package edu.miu.lab2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Course {
    private int id;
    private String name;
    private int code;
    private boolean deleted;
}
