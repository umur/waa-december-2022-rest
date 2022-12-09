package edu.miu.lab2.controller;

import edu.miu.lab2.entity.Course;
import edu.miu.lab2.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
@CrossOrigin
public class CourseController {

    private final CourseService  courseService;

    @GetMapping
    public List<Course> getAll() {
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable int id) {
        return courseService.findById(id);
    }

    @GetMapping("/filter/student/{studentId}")
    public List<Course> getCoursesByStudentId(@PathVariable int studentId)  {
        return courseService.getCoursesByStudentId(studentId);
    }

    @PostMapping
    public String add(@RequestBody Course course) {
        var result = courseService.add(course);

        if(result)
            return "Saved successfully.";
        else
            return "Error during create operation.";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Course course) {
        var result = courseService.update(id, course);

        if(result)
            return "Updated successfully.";
        else
            return "Error during update operation.";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        var result = courseService.delete(id);

        if(result)
            return "Deleted successfully.";
        else
            return "Error during delete operation.";
    }
}
