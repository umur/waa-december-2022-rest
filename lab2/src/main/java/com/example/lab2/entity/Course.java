package com.example.lab2.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
@Data
public class Course {
    private int id;
    private String name;
    private String code;

    public Course(int id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }
}
