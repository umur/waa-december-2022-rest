package waa.lab2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import waa.lab2.entity.Course;
import waa.lab2.services.CourseService;

import java.util.List;

/**
 * @author Ankhbayar Azzaya
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<Course> getAll() {
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable int id) {
        return courseService.getById(id);
    }

    @PostMapping()
    public void create(@RequestBody Course course) {
        courseService.save(course);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Course course) {
        courseService.update(id, course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        courseService.delete(id);
    }

}
