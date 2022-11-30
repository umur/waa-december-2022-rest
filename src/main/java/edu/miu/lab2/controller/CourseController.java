package edu.miu.lab2.controller;

import edu.miu.lab2.model.dto.CourseDTO;
import edu.miu.lab2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<CourseDTO> getAllProducts(){
        return courseService.getAllProducts();
    }
    @PostMapping
    public void addCourse(@RequestBody CourseDTO courseDTO){
        courseService.addCourse(courseDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id){
        courseService.deleteCourse(id);
    }

    @PutMapping("/{id}")
    public void updateCourse(@PathVariable int id, @RequestBody CourseDTO courseDTO){
        courseService.updateCourse(id, courseDTO);
    }
}
