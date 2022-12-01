package com.example.labtwo.service;

import com.example.labtwo.dto.CourseDto;
import com.example.labtwo.dto.StudentDto;
import com.example.labtwo.entity.Student;

import java.util.List;

public interface StudentService {
    void add(StudentDto student);
    StudentDto getById(int id);
    void update(int id, StudentDto student);
    void delete (int id);

    List<StudentDto> getStudentsByMajor(String major);
    List<CourseDto> getCoursesByStudentId(int id);
}
