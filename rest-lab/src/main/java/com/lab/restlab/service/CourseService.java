package com.lab.restlab.service;

import com.lab.restlab.dto.CourseDto;

import java.util.List;

public interface CourseService {
    List<CourseDto> getAll();
    CourseDto getById(int id);
    void save(CourseDto courseDto);
    CourseDto update(int id, CourseDto courseDto);
    void delete(int id);

}
