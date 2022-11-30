package lab.waa.rest.controller;

import lab.waa.rest.entity.Course;
import lab.waa.rest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getCourses(int offset, int count){
        return courseService.getCourses(offset, count);
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable int id){
        return  courseService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody Course course){
        courseService.save(course);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Course course){
        courseService.updateById(id, course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        courseService.deleteById(id);
    }
}
