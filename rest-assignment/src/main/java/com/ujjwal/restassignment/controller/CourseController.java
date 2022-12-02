package com.ujjwal.restassignment.controller;

import com.ujjwal.restassignment.dto.CourseDto;
import com.ujjwal.restassignment.service.CourseService;
import com.ujjwal.restassignment.service.implementation.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RequestMapping("/courses")
@RestController
public class CourseController {
    CourseService courseService;
    @Autowired
    CourseController(CourseServiceImpl courseServiceImpl)
    {
        this.courseService = courseServiceImpl;
    }

    @GetMapping
    public List<CourseDto> getCourses(){
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public CourseDto getById(@PathVariable int id){
        return courseService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody CourseDto course){
        courseService.save(course);
    }

    @PutMapping("/{id}")
    public CourseDto update(@PathVariable int id, @RequestBody CourseDto course){
        return courseService.update(id, course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        courseService.delete(id);
    }
}
