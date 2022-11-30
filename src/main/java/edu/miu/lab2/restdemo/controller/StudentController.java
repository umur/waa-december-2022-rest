package edu.miu.lab2.restdemo.controller;

import edu.miu.lab2.restdemo.dto.StudentDto;
import edu.miu.lab2.restdemo.entity.Student;
import edu.miu.lab2.restdemo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    public Student getId(@PathVariable int id) {
        return studentService.getId(id);
    }

    @PostMapping
    public void create(@RequestBody Student student) {
        studentService.save(student);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Student student) {
        studentService.update(student,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        studentService.delete(id);
    }


}
