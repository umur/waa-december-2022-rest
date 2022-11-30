package edu.miu.lab2.model;

import lombok.Data;

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
