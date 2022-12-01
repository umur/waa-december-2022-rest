package edu.miu.lab2.service;

import edu.miu.lab2.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    List<Course> getAllCourses();

    void addCourse(Course course);

    Course getCourseById(int id);

    void deleteCourse(int id);

}
