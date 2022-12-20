package edu.miu.w1d2rest.service;

import edu.miu.w1d2rest.dto.CourseDto;
import edu.miu.w1d2rest.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAll();
    List<StudentDto> getAllByMajor(String major);
    List<CourseDto> getCoursesByStudentId(int id);
    StudentDto getById(int id);
    void save(StudentDto student);
    void update(int id, StudentDto student);
    void delete(int id);
}
