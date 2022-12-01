package Waa.lab2.services;


import Waa.lab2.entity.Course;

import java.util.List;

public interface CourseService {
    public List<Course> GetCoursesByStudentId(int StudentId);
    public void Add(Course course);
    public void Update(Course course, int id);
    public void Delete(int id);
    public List<Course> GetAll();



}
