package edu.miu.lab2_assignment.service;

import edu.miu.lab2_assignment.entity.Student;

import java.util.List;

public interface StudentService {

    //Implementing CRUD
    public List<Student> getStudentList();
    public Student getById(int id);
    public void save(Student student);
    public void update (int id, Student student);
    public void deleteById(int id);

}