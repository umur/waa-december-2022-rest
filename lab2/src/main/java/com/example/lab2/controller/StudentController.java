package com.example.lab2.controller;

import com.example.lab2.dto.StudentBasicDto;
import com.example.lab2.entity.Course;
import com.example.lab2.entity.Student;
import com.example.lab2.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @CrossOrigin
    @GetMapping
    public List<StudentBasicDto> getAllStudent(){
        return studentService.getAllStudent();
    }
    @CrossOrigin
    @GetMapping("/{id}/courses")
    public  List<Course> getCourseByStudentId(@PathVariable int id) {
        return studentService.getCourseByStudentId(id);
    }
    @CrossOrigin
    @GetMapping("/filterByMajor")
    public List<Student> getStudentsByMajor(@RequestParam("major") String major) {
        System.out.println("hello from controller 3");
        System.out.println("=====" + major);
        return studentService.getStudentsByMajor(major);
    }
    //using Path variable
//    @GetMapping("/{major}/major")
//    public List<Student> getStudentsByMajor(@PathVariable String major) {
//        System.out.println("hello from controller 3");
//        System.out.println("=====" + major);
//        return studentService.getStudentsByMajor(major);
//    }
    @CrossOrigin
    @GetMapping("/{id}")
    public StudentBasicDto getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @CrossOrigin
    @PostMapping
    public void create(@RequestBody Student student){
        studentService.save(student);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody StudentBasicDto student){
        studentService.updateStudent(id,student);
    }
    @CrossOrigin
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
       return studentService.deleteStudentById(id);
    }



}
