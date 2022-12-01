package com.example.lab2.service;
import com.example.lab2.dto.CourseBasicDto;
import com.example.lab2.entity.Course;

import java.util.List;

public interface CourseService {

    CourseBasicDto getCourseById(int id);
    void save(Course s);
    List<CourseBasicDto> getAllCourses();
    String deleteCourseById(int id);
    void updateCourse(int id, CourseBasicDto course);

}