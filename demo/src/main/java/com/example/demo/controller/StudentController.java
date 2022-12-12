package com.example.demo.controller;


import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;


    @GetMapping("/students/all")
    public String getAllStudents(Model model){
        List<Student> studentList = studentService.getAllStudents();
        model.addAttribute("students", studentList);
        return "index";
    }
    @GetMapping("/students")
    public String getStudentsByMajor(@RequestParam String major, Model model) {
        if(!major.isEmpty()){
            List<Student>  studentList= studentService.getAllStudentByMajor(major);
            model.addAttribute("students", studentList);
            return  "index";
        }else {
            return getAllStudents(model);
        }


    }
    @GetMapping("/students/courses/{studentId}")
    @ResponseBody
    public String getCourseByStudentId(@PathVariable int studentId, Model model) {
        List<Course> courseList = studentService.getCourseByStudentId(studentId);
        model.addAttribute("courses", courseList);
        return "course";
    }
}
