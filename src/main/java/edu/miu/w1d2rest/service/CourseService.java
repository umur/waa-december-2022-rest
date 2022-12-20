package edu.miu.w1d2rest.service;

import edu.miu.w1d2rest.dto.CourseDto;
import edu.miu.w1d2rest.entity.Course;

import java.util.List;

public interface CourseService {
    List<CourseDto> getAll();
    CourseDto getById(int id);
    void save(CourseDto product);
    void update(int id, CourseDto product);
    void delete(int id);
}
