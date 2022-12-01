package edu.miu.lab2_assignment.controller;

import edu.miu.lab2_assignment.entity.Student;
import edu.miu.lab2_assignment.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")

public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<Student> studentList(){
        System.out.println("Get All Request Received successfully");
        return studentService.getStudentList();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable int id){
        System.out.println("Get Request received for id:" + String.valueOf(id));
        return studentService.getById(id);
    }
    @PostMapping
    public void create(@RequestBody Student student){
        System.out.println("Post Request received: " + student.toString());
        studentService.save(student);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Student student){
        System.out.println("Update Request received for id: " + String.valueOf(id) + " with request body: " + student.toString());
        studentService.update(id, student);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        System.out.println("Delete request received for id: " + String.valueOf(id));
        studentService.deleteById(id);
    }


}
