package com.example.lab2.service.impl;

import com.example.lab2.dto.CourseBasicDto;
import com.example.lab2.entity.Course;
import com.example.lab2.repository.CourseRepo;
import com.example.lab2.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepo courseRepo;

    private ModelMapper modelMapper;

    public CourseServiceImpl(CourseRepo courseRepo, ModelMapper modelMapper){
        this.modelMapper=modelMapper;
        this.courseRepo=courseRepo;
    }

    public void save(Course s){
        courseRepo.save(s);
    }

    public String deleteCourseById(int id){
        return courseRepo.deleteCourseById(id);
    }

    public List<CourseBasicDto> getAllCourses(){
        List<Course> courses = courseRepo.getAllCourses();
        return courses
                .stream()
                .map(course->modelMapper.map(course, CourseBasicDto.class))
                .toList();
    }
    public CourseBasicDto getCourseById(int id){
        Course course = courseRepo.getCourseById(id);
        return modelMapper.map(course,CourseBasicDto.class);
    }
    public void updateCourse(int id, CourseBasicDto course){
        courseRepo.updateCourse(id,modelMapper.map(course, Course.class));
    }




}
