package edu.miu.lab2.restdemo.service;

import edu.miu.lab2.restdemo.dto.CourseDto;
import edu.miu.lab2.restdemo.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getCourses();
    Course getId (int id);
    void update(Course c, int id);
    void delete(int id);
}
