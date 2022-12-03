package edu.miu.restdemo.service;

import edu.miu.restdemo.dto.CourseDto;

import java.util.List;

public interface CourseService {

    CourseDto getById(int id);

    void save(CourseDto p);

    List<CourseDto> getAllCourses();


//    List<BasicProductDto> getBasicProducts();

}
