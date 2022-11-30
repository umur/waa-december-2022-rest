package miu.edu.waalab2.controller;

import miu.edu.waalab2.entity.Course;
import miu.edu.waalab2.entity.Student;
import miu.edu.waalab2.service.StudentService;
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

    @GetMapping("/hello")
    public String getHello(Model model){
        model.addAttribute("theDate", new Date());
        return "index";
    }

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
