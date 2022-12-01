package com.projectStudent.Student_management_App.Controller;


import com.projectStudent.Student_management_App.Entity.Student;
import com.projectStudent.Student_management_App.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;



    @GetMapping("/getAll")
    public List<Student> getAll(){
        return  studentService.getAll();

    }

    @PostMapping("/add")
    public String addStudent(@RequestBody  Student student){
        return studentService.addStudent(student);
    }

    @PutMapping("/modify")
    public String modStudent(@RequestBody  Student student){
        return studentService.modStudent(student);
    }

    @DeleteMapping("/del")
    public String delStudent(@RequestParam int id){
      return  studentService.delStudent(id);
    }

    @GetMapping("/filterByMajor")
    public List<Student> getStudentByMajor(@RequestParam  String major){
        return studentService.getStudentByMajor(major);
    }
     @GetMapping("/filterById")
    public List<Student> getCourseByStudentID(@RequestParam int stdId){
        return studentService.getCourseByStudentID(stdId);
    }
}
