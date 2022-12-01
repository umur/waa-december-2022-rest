package com.ujjwal.restassignment.service.implementation;

import com.ujjwal.restassignment.entity.Course;
import com.ujjwal.restassignment.repository.CourseRepository;
import com.ujjwal.restassignment.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public Course update(int id, Course course) {
        return courseRepository.update(id, course);
    }

    @Override
    public void delete(int id) {
        courseRepository.delete(id);
    }

    @Override
    public Course getById(int id) {
        return courseRepository.getById(id);
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.getAll();
    }
}
