package miu.edu.waa.lab2.service;

import java.util.List;

import miu.edu.waa.lab2.model.dto.CourseDTO;

public interface CourseService {
    List<CourseDTO> getAllCourses();

    CourseDTO getCourseById(int id);

    List<CourseDTO> getCoursesByStudentId(int studentId);

    boolean addCourse(CourseDTO courseDTO);

    CourseDTO updateCourse(int id, CourseDTO courseDTO);

    boolean deleteCourse(int id);
}
