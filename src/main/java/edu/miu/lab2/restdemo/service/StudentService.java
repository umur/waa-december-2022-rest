package edu.miu.lab2.restdemo.service;

import edu.miu.lab2.restdemo.dto.StudentDto;
import edu.miu.lab2.restdemo.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    Student getId(int id);
    void update (Student c, int id);
    void delete(int id);

    void save(Student student);
}
