package edu.miu.lab2.service;

import edu.miu.lab2.entity.Course;

import java.util.List;

public interface CourseService {

    Course findById(int id);

    List<Course> getAll();

    List<Course> getCoursesByStudentId(int studentId);

    boolean add(Course c);

    boolean update(int id, Course s);

    boolean delete(int id);
}
