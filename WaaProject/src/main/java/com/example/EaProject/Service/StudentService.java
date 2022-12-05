package com.example.EaProject.Service;

import com.example.EaProject.Entity.Course;
import com.example.EaProject.Entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {
    public List<Student> GetStudentsByMajor(String major);

    public void Add(Student student);
    public void Update(Student student, int id);
    public void Delete(int id);
    public List<Student> GetAll();

}
