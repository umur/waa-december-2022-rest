package com.example.EaProject.Controller;

import com.example.EaProject.Entity.Course;
import com.example.EaProject.Service.CourseService;
import com.example.EaProject.Service.ServiceImpl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    CourseService courseService;

    @Autowired
    CourseController(CourseServiceImpl courseServiceImpl)
    {
        this.courseService = courseServiceImpl;
    }

    @GetMapping("/getStudentsByStudentId")
    public List<Course> getCoursesByStudentId(@RequestParam int studentId) {
        return  courseService.GetCoursesByStudentId(studentId);
    }

    @PostMapping()
    public void add(@RequestBody Course course)
    {
        courseService.Add(course);
    }
    @GetMapping
    public List<Course> get()
    {
      return courseService.GetAll();
    }

    @PutMapping("/{id}")
    public void update( @PathVariable int id,@RequestBody Course course)
    {
        courseService.Update(course,id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable  int id)
    {
        courseService.Delete(id);
    }
}
