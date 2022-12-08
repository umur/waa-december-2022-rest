package MIU.edu.studentsrestapi.controllers;

import MIU.edu.studentsrestapi.dtos.CourseDto;
import MIU.edu.studentsrestapi.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    
    @GetMapping
    public List<CourseDto> getCourses() {
        return courseService.getCourses();
    }

    
    @GetMapping("/{courseId}")
    public CourseDto getCourse(@PathVariable int courseId) {
        return courseService.getCourse(courseId);
    }


    @DeleteMapping("/{courseId}")
    public String deleteCourse(@PathVariable int courseId) {
        return courseService.deleteCourse(courseId);
    }

    
    @PostMapping
    public String addCourse(@RequestBody CourseDto courseDto) {
        return courseService.addCourse(courseDto);
    }

    
    @PutMapping("/{courseId}")
    public String updateCourse(@PathVariable int courseId, @RequestBody CourseDto courseDto) {
        return courseService.updateCourse(courseId, courseDto);
    }
}
