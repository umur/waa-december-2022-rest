package edu.miu.w1d2.controller;

import edu.miu.w1d2.dto.CourseDto;
import edu.miu.w1d2.service.CourseService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/course")
@CrossOrigin
@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    public void createCourse(@RequestBody CourseDto course){
        courseService.create(course);
    }
    @PutMapping("/{id}")
    public void updateCourse(@RequestBody CourseDto courseDto,@PathVariable int id){
        courseService.update(courseDto,id);
    }

    @GetMapping
    public List<CourseDto> getAllCourse(){
        return courseService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int  id){
         courseService.delete(id);
    }
    @GetMapping("/{id}")
    public CourseDto getCourseById(@PathVariable int id){

        return courseService.getById(id);
    }

}
