package com.ujjwal.restassignment.controller;

import com.ujjwal.restassignment.dto.CourseDto;
import com.ujjwal.restassignment.dto.StudentDto;
import com.ujjwal.restassignment.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public void save(@RequestBody StudentDto studentDto){
        studentService.save(studentDto);
    }

    @GetMapping("/{id}")
    public StudentDto getById(@PathVariable int id){
        return studentService.getById(id);
    }

    @GetMapping("/filterByMajor")
    public List<StudentDto> getStudentsByMajor(@RequestParam String major){
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{studentId}/courses")
    public List<CourseDto> getCoursesByStudentId(@PathVariable int studentId){
        return studentService.getCoursesByStudentId(studentId);
    }
    @GetMapping
    public List<StudentDto> getAll(){
        return studentService.getAll();
    }
    @PutMapping("/{id}")
    public StudentDto update(@PathVariable int id, @RequestBody StudentDto studentDto) {
        return studentService.update(id, studentDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        studentService.delete(id);
    }
}
