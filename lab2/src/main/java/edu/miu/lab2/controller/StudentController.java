package edu.miu.lab2.controller;

import edu.miu.lab2.entity.Course;
import edu.miu.lab2.entity.Student;
import edu.miu.lab2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @PostMapping
    public void createStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudemt (@PathVariable int id){
        studentService.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public void updateStudemt (@PathVariable int id, @RequestBody Student student){
        studentService.deleteStudent(id);
    }

    @GetMapping("/filterByMajor")
    public List<Student> getStudentsByMajor(@RequestParam String major){
       return studentService.getStudentByMajor(major);
    }
    @GetMapping("/{id}/courses")
    public List<Course> getStudentCourses(@PathVariable int id){
        return studentService.getStudentCourses(id);
    }
}
