package com.example.labtwo.service;

import com.example.labtwo.dto.CourseDto;
import com.example.labtwo.entity.Course;
import com.example.labtwo.entity.Student;

public interface CourseService {
    void add(CourseDto course);
    CourseDto getCourseById(int id);
    void update(int id, CourseDto course);
    void delete (int id);
}
