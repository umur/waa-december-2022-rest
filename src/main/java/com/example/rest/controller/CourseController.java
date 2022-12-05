package com.example.rest.controller;


import com.example.rest.entity.Course;
import com.example.rest.servce.CourseService;
import com.example.rest.servce.ServiceImpl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    CourseService courseService;

    @Autowired
    CourseController(CourseServiceImpl courseServiceImpl)
    {
        this.courseService = courseServiceImpl;
    }

    @GetMapping("/getStudentsByStudentId")
    public List<Course> getCoursesByStudentId(@RequestParam int studentId) {
        return  courseService.GetCoursesByStudentId(studentId);
    }

    @PostMapping()
    public void add(@RequestBody Course course)
    {
        courseService.Add(course);
    }
    @GetMapping
    public List<Course> get()
    {
      return courseService.GetAll();
    }

    @PutMapping("/{id}")
    public void update( @PathVariable int id,@RequestBody Course course)
    {
        courseService.Update(course,id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable  int id)
    {
        courseService.Delete(id);
    }
}
