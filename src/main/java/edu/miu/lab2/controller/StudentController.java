package edu.miu.lab2.controller;

import edu.miu.lab2.model.Course;
import edu.miu.lab2.model.Student;
import edu.miu.lab2.model.dto.StudentDTO;
import edu.miu.lab2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    public StudentService studentService;

    @GetMapping
    public List<StudentDTO> findAllStudents(){
        return studentService.findAllStudents();
    }
    @PostMapping
    public void addStudent(@RequestBody StudentDTO studentDTO){
        studentService.addStudent(studentDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
    }
    @PutMapping("/{id}")
    public void updateStudent(@PathVariable int id, @RequestBody StudentDTO studentDTO){
        studentService.updateStudent(id, studentDTO);
    }

    @GetMapping("/filter")
    public List<Student> getStudentsByMajor(@RequestParam String major){
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{id}")
    public List<Course> getCoursesByStudentId(@PathVariable int studentId){
        return studentService.getCoursesByStudentId(studentId);
    }
}
