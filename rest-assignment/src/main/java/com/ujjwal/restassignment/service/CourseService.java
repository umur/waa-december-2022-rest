package com.ujjwal.restassignment.service;

import com.ujjwal.restassignment.dto.CourseDto;

import java.util.List;

public interface CourseService {
//    adding a new course
    void save(CourseDto course);
//    updating a course
    CourseDto update(int id, CourseDto course);
//    deleting a course
    void delete(int id);
//    getting a single course
    CourseDto getById(int id);
//    getting all the courses
    List<CourseDto> getAll();
}


