package edu.miu.restdemo.controller;

import edu.miu.restdemo.dto.StudentDto;
import edu.miu.restdemo.dto.CourseDto;
import edu.miu.restdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/students")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentController {


    @Autowired
    private StudentService studentService;


    @GetMapping
    public List<StudentDto> getAll(){
        System.out.println("get all is running");
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentDto getById(@PathVariable int id){
        System.out.println("get by id is running");
        return studentService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody StudentDto s){
        studentService.save(s);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        System.out.println("delete is running");
        boolean result = studentService.delete(id);
        System.out.printf("is Delete successful? %s", result);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody StudentDto product){
        System.out.println("update is running");
        //todo update repo and service
    }

    @GetMapping("/searchCourses")
    public List<CourseDto> getCoursesByStudentId(@RequestParam int id){
        System.out.printf("get getCoursesByStudentId %s%n", id);

        return studentService.getCoursesByStudentId(id);
    }

    @GetMapping("/filterByMajor")
    public List<StudentDto> getStudentsByMajor(@RequestParam String major){
        System.out.printf("get StudentByMajor %s%n", major);

        return studentService.getStudentsByMajor(major);
    }
}
