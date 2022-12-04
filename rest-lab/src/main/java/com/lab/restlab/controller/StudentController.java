package com.lab.restlab.controller;

import com.lab.restlab.dto.CourseDto;
import com.lab.restlab.dto.StudentDto;
import com.lab.restlab.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/students")
@RestController
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class StudentController {
    private final StudentService studentService;

    @GetMapping()
    public List<StudentDto> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public StudentDto getById(@PathVariable int id) {
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

    @PostMapping()
    public void save(@RequestBody StudentDto studentDto) {
        studentService.save(studentDto);
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
