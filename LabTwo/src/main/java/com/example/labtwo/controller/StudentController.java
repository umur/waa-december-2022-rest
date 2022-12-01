package com.example.labtwo.controller;

import com.example.labtwo.dto.CourseDto;
import com.example.labtwo.dto.StudentDto;
import com.example.labtwo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/{id}")
    public StudentDto getById(@PathVariable int id){
        System.out.println("Get id: " + String.valueOf(id));
        return studentService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody StudentDto student){
        System.out.println("Post request received: " + student.toString());
        studentService.add(student);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody StudentDto student){
        System.out.println("Update request received for id: " + String.valueOf(id) + " with request body: " + student.toString());
        studentService.update(id, student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        System.out.println("Delete request received for id: " + String.valueOf(id));
        studentService.delete(id);
    }

    @GetMapping("/filterByMajor")
    public List<StudentDto> getStudentsByMajor(@RequestParam String major){
        System.out.println("Get Students by major request received.");
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{id}/courses")
    public List<CourseDto> getCoursesByStudentId(@PathVariable int id){
        System.out.println("Get courses taken by student id request received.");
        return studentService.getCoursesByStudentId(id);
    }
}
