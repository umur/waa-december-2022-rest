package edu.miu.lab2.service;

import edu.miu.lab2.entity.Student;

import java.util.List;

public interface StudentService {

    Student findById(int id);

    List<Student> getAll();

    List<Student> getStudentsByMajor(String major);

    boolean add(Student s);

    boolean update(int id, Student s);

    boolean delete(int id);
}
