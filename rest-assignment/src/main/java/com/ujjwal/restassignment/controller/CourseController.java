package com.ujjwal.restassignment.controller;

import com.ujjwal.restassignment.entity.Course;
import com.ujjwal.restassignment.service.CourseService;
import com.ujjwal.restassignment.service.implementation.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Course> getCourses(){
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable int id){
        return courseService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody Course course){
        courseService.save(course);
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable int id, @RequestBody Course course){
        return courseService.update(id, course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        courseService.delete(id);
    }
}
