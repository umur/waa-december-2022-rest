package Waa.Lab2.Entity;

import lombok.Data;

import java.util.List;

@Data
public class Course {
    private String name;
    private int id;
    private int code;

    public Course(String name, int id, int code) {
        this.name = name;
        this.id = id;
        this.code = code;
    }


}
