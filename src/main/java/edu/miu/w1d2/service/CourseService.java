package edu.miu.w1d2.service;

import edu.miu.w1d2.dto.CourseDto;
import edu.miu.w1d2.dto.StudentDto;

import java.util.List;

public interface CourseService {
    List<CourseDto> getAll();
    CourseDto getById(int id);
    void create(CourseDto c);
    void delete(int id);
    void update(CourseDto c,int id);
    List<CourseDto> getAllCourseOfStudents();

}
