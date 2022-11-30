package edu.miu.lab2.service;

import edu.miu.lab2.model.Course;
import edu.miu.lab2.model.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    public List<CourseDTO> getAllProducts();
    public void addCourse(CourseDTO courseDTO);
    public void deleteCourse(int id);
    public void updateCourse(int id, CourseDTO courseDTO);
}
