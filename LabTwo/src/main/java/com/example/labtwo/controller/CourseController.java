package com.example.labtwo.controller;

import com.example.labtwo.dto.CourseDto;
import com.example.labtwo.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping("/{id}")
    public CourseDto getCourseById(@PathVariable int id){
        System.out.println("Get request received for id: " + String.valueOf(id));
        return courseService.getCourseById(id);
    }

    @PostMapping
    public void create(@RequestBody CourseDto course){
        System.out.println("Post request received: " + course.toString());
        courseService.add(course);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody CourseDto course){
        System.out.println("Update id: " + String.valueOf(id) + " with request body: " + course.toString());
        courseService.update(id, course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        System.out.println("Delete id: " + String.valueOf(id));
        courseService.delete(id);
    }



}
