package com.example.lab2.controller;

import com.example.lab2.dto.CourseBasicDto;
import com.example.lab2.entity.Course;
import com.example.lab2.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseBasicDto> getAllCourse(){
        return courseService.getAllCourses();
    }



    @GetMapping("/{id}")
    public CourseBasicDto getCourseById(@PathVariable int id){
        return courseService.getCourseById(id);
    }

    @PostMapping
    public void create(@RequestBody Course course){
        courseService.save(course);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody CourseBasicDto course){
        courseService.updateCourse(id,course);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        return courseService.deleteCourseById(id);
    }

}
