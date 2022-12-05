package com.example.EaProject.Service;

import com.example.EaProject.Entity.Course;
import com.example.EaProject.Entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CourseService {
    public List<Course> GetCoursesByStudentId(int StudentId);
    public void Add(Course course);
    public void Update(Course course, int id);
    public void Delete(int id);
    public List<Course> GetAll();
}
