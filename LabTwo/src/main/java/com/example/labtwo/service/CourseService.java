package com.example.labtwo.service;


import com.example.labtwo.entity.Course;

import java.util.List;

public interface CourseService {
    void add(Course course);
    List<Course> getCourseById(int id);
    void update(int id, Course course);
    void delete (int id);
}
