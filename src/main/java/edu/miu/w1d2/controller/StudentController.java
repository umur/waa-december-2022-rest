package edu.miu.w1d2.controller;

import edu.miu.w1d2.dto.CourseDto;
import edu.miu.w1d2.dto.StudentDto;
import edu.miu.w1d2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequestMapping("/student")
@CrossOrigin
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/major")
    public List<StudentDto> getStudentsByMajor(@RequestParam String major){
       return  studentService.getByMajor(major);
    }


    @GetMapping
    public List<StudentDto> getAllStudents(){
        System.out.println("course is out");
        return  studentService.getAll();
    }

    @PostMapping
    public void createStudent(@RequestBody StudentDto studentDto){
         studentService.create(studentDto);
    }

    @PutMapping("/{id}")
    public void updateStudent(@RequestBody StudentDto studentDto,@PathVariable int id){
        studentService.update(studentDto,id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.delete(id);
    }
    @GetMapping("/{id}/courses")
    public List<CourseDto> getCoursesByStudentId(@PathVariable int id){
        System.out.println("course is out");
        return  studentService.getCourseByStudentId(id);
    }

    @GetMapping("/{id}")
    public StudentDto getById(@PathVariable int id){
        System.out.println( "get student By id");
        return  studentService.getById(id);
    }


}
