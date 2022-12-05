package com.example.rest.controller;


import com.example.rest.entity.Student;
import com.example.rest.servce.ServiceImpl.StudentServiceImpl;
import com.example.rest.servce.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {


    StudentService studentService;

    @Autowired
    StudentController(StudentServiceImpl studentServiceImpl)
    {
        this.studentService = studentServiceImpl;
    }


    @GetMapping("/getStudentsByMajor")
    public List<Student> getStudentsByMajor(@RequestParam String major) {
        return  studentService.GetStudentsByMajor(major);
    }

    @PostMapping
    public void add(@RequestBody Student student)
    {
        studentService.Add(student);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Student student, @PathVariable int id)
    {
        studentService.Update(student,id);
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable int id)
    {
        studentService.Delete(id);
    }

}