package com.lab.restlab.service;

import com.lab.restlab.dto.CourseDto;
import com.lab.restlab.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAll();
    StudentDto getById(int id);
    List<StudentDto> getStudentsByMajor(String major);
    List<CourseDto> getCoursesByStudentId(int studentId);
    void save(StudentDto studentDto);
    StudentDto update(int id, StudentDto studentDto);
    void delete(int id);
}
