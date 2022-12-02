package com.ujjwal.restassignment.service;

import com.ujjwal.restassignment.dto.CourseDto;
import com.ujjwal.restassignment.dto.StudentDto;
import com.ujjwal.restassignment.entity.Student;

import java.util.List;

public interface StudentService {
    //    adding a new student
    void save(StudentDto studentDto);
    //    updating a student
    StudentDto update(int id, StudentDto studentDto);
    //    deleting a student
    void delete(int id);
    //    getting a single course
    StudentDto getById(int id);
    //    getting all the courses
    List<StudentDto> getAll();
    //    get all students by major
    List<StudentDto> getStudentsByMajor(String major);
    //    get all courses of the student
    List<CourseDto> getCoursesByStudentId(int studentId);
}
