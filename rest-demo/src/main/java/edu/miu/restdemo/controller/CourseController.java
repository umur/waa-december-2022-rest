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
    public void create(@RequestBody CourseDto courseDto){
        System.out.println("create is running");
        courseService.save(courseDto);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        System.out.println("delete is running");
        courseService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody CourseDto courseDto){
        System.out.println("delete is running");
        courseService.update(id,courseDto);
    }

}
