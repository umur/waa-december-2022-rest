package com.lab.restlab.service.impl;

import com.lab.restlab.dto.CourseDto;
import com.lab.restlab.entity.Course;
import com.lab.restlab.repository.CourseRepository;
import com.lab.restlab.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CourseDto> getAll() {
        return courseRepository.getAll().stream().map(c -> modelMapper.map(c, CourseDto.class)).toList();
    }

    @Override
    public CourseDto getById(int id) {
        Course result = courseRepository.getById(id);
        return modelMapper.map(result, CourseDto.class);
    }

    @Override
    public void save(CourseDto courseDto) {
        Course course = modelMapper.map(courseDto, Course.class);
        courseRepository.save(course);
    }

    @Override
    public CourseDto update(int id, CourseDto courseDto) {
        Course course = modelMapper.map(courseDto, Course.class);
        Course result = courseRepository.update(id, course);
        return modelMapper.map(result, CourseDto.class);
    }

    @Override
    public void delete(int id) {
        courseRepository.delete(id);
    }
}
