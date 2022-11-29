package miu.edu.waa.lab2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import miu.edu.waa.lab2.model.dto.CourseDTO;
import miu.edu.waa.lab2.service.CourseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    private List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    private CourseDTO getCourseById(@PathVariable int id) {
        return courseService.getCourseById(id);
    }

    @GetMapping("/students/{student_id}")
    private List<CourseDTO> getCoursesByStudentId(@PathVariable int student_id) {
        return courseService.getCoursesByStudentId(student_id);
    }

    @PostMapping
    public boolean addCourse(@RequestBody CourseDTO courseDTO) {
        return courseService.addCourse(courseDTO);
    }

    @PutMapping("/{id}")
    public CourseDTO updateCourse(@PathVariable int id, @RequestBody CourseDTO courseDTO) {
        return courseService.updateCourse(id, courseDTO);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCourse(@PathVariable int id) {
        return courseService.deleteCourse(id);
    }

}
