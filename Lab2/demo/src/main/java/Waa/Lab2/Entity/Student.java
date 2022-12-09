package Waa.Lab2.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
@Data
@RequiredArgsConstructor
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<Course> coursesTaken;

    public Student(int i, String gilbert, String mumbere, String s, String msd, List<Course> asList) {
    }
}
