package edu.miu.w1d2rest.controller;

import edu.miu.w1d2rest.dto.CourseDto;
import edu.miu.w1d2rest.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "null,http://localhost:8080")
@RequestMapping("/courses")
@RestController
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public List<CourseDto> getAll(){
        System.out.println("Get all request received.");
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public CourseDto getById(@PathVariable int id){
        System.out.println("Get request received for id: " + String.valueOf(id));
        return courseService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody CourseDto course){
        System.out.println("Post request received: " + course.toString());
        courseService.save(course);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody CourseDto course){
        System.out.println("Update request received for id: " + String.valueOf(id) + " with request body: " + course.toString());
        courseService.update(id, course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        System.out.println("Delete request received for id: " + String.valueOf(id));
        courseService.delete(id);
    }
}
