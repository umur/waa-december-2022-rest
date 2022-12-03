package edu.miu.restdemo.controller;

import edu.miu.restdemo.dto.CourseDto;
import edu.miu.restdemo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/courses")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CourseController {


    @Autowired
    private CourseService courseService;


    @GetMapping
    public List<CourseDto> getAll(){
        System.out.println("get all is running");
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public CourseDto getById(@PathVariable int id){
        System.out.println("get by id is running");
        return courseService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody CourseDto product){
        System.out.println("create is running");
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        System.out.println("delete is running");
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody CourseDto product){
        System.out.println("update is running");
    }

}
