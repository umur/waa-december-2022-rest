package com.example.labtwo.service;

import com.example.labtwo.entity.Student;

import java.util.List;

public interface StudentService {
    void add(Student student);
    Student getById(int id);
    void update(int id, Student student);
    void delete (int id);

    List<Student> getStudentsByMajor(String major);
    List<Student> getCoursesByStudentId(int id);
}
