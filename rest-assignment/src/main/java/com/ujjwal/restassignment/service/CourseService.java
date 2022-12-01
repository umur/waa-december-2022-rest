package com.ujjwal.restassignment.service;

import com.ujjwal.restassignment.entity.Course;

import java.util.List;

public interface CourseService {
//    adding a new course
    void save(Course course);
//    updating a course
    Course update(int id, Course course);
//    deleting a course
    void delete(int id);
//    getting a single course
    Course getById(int id);
//    getting all the courses
    List<Course> getAll();
}


