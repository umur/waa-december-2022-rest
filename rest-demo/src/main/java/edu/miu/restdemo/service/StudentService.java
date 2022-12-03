package edu.miu.restdemo.service;

import edu.miu.restdemo.dto.CourseDto;
import edu.miu.restdemo.dto.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto getById(int id);

    void save(StudentDto s);

    List<StudentDto> getAllStudents();

    List<StudentDto> getStudentsByMajor(String major);

    List<CourseDto> getCoursesByStudentId(int studentId);

    boolean delete(int id);
}
