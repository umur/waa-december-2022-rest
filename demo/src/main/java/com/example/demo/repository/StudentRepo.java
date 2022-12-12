package com.example.demo.repository;


import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class StudentRepo {
    static List<Student> studentList = new ArrayList<>();
    static List<Course> courses1 = Arrays.asList(new Course(1, "Computer Science", "CS575"), new Course(1, "Biology", "Bio265"), new Course(4, "Physics", "phy223"));
    static List<Course> courses2 = Arrays.asList( new Course(3, "Math", "M12"), new Course(4, "Literature", "lt258"));
    static List<Course> courses3 = Arrays.asList(new Course(1, "Computer Science", "cp548"), new Course(1, "Biology", "nr223"), new Course(4, "Physics", "bs356"));

    static {
        studentList.add(new Student(1, "Sameer", "Adhikari", "sameer@gmail.com", "Computer Science", courses1));
        studentList.add(new Student(2, "Hari", "Thapa", "thapa@gmail.com", "Literature", courses2));
        studentList.add(new Student(3, "Ram", "Kumar", "ram@gmail.com", "Computer", courses3));
    }


    public List<Student> getAllStudentByMajor(String major) {
        System.out.println(major);
        return studentList.stream().filter((student -> student.getMajor().equalsIgnoreCase(major))).collect(Collectors.toList());
    }
    public List<Course> getAllStudentByMajor(int studentId){
        return  studentList.stream().filter(student -> student.getId() == studentId).findFirst().get().getCoursesTaken();
    }
    public List<Student> getAllStudents(){
        return  studentList;
    }
}



