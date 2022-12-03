package edu.miu.restdemo.service;

import edu.miu.restdemo.dto.CourseDto;
import edu.miu.restdemo.entity.Student;

import java.util.List;

public interface CourseService {

    CourseDto getById(int id);

    void save(CourseDto p);

    List<CourseDto> getAllCourses();

    void delete(int id);
    void update(int id, CourseDto c);
//    List<BasicProductDto> getBasicProducts();

}
