package Waa.Lab2.Controller;


import Waa.Lab2.Entity.Course;
import Waa.Lab2.Services.Serviceimpl.CourseService;
import Waa.Lab2.Services.Serviceimpl.StudentImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/course")
    public class CourseController {

        CourseService courseService;
        StudentImpl studentService;



        @GetMapping("/getStudentsByStudentId")
        public List<Course> getCoursesByStudentId(@RequestParam int studentId) {
            return  studentService.getCoursesByStudentId(studentId);
        }

        @PostMapping()
        public void add(@RequestBody Course course)
        {
            courseService.add(course);
        }
        @GetMapping
        public List<Course> get()
        {
            return courseService.getAllCourses();
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable  int id)
        {
            courseService.delete(id);
        }
    }

