package edu.miu.lab2.restdemo.controller;

import edu.miu.lab2.restdemo.dto.CourseDto;
import edu.miu.lab2.restdemo.entity.Course;
import edu.miu.lab2.restdemo.service.CourseService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor

public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    @GetMapping("/{id}")
    public Course getId(@PathVariable int id) {
        return courseService.getId(id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Course courseDto, @PathVariable Integer id) {
        courseService.update(courseDto, id);
    }

    @DeleteMapping
    public void delete(@PathVariable Integer id) {
        courseService.delete(id);
    }
}
