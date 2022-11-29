package miu.edu.waa.lab2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import miu.edu.waa.lab2.model.dto.StudentDTO;
import miu.edu.waa.lab2.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    private List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    private StudentDTO getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/filter")
    private List<StudentDTO> getStudentsByMajor(@RequestParam String major) {
        return studentService.getStudentsByMajor(major);
    }

    @PostMapping
    public boolean addStudent(@RequestBody StudentDTO StudentDTO) {
        return studentService.addStudent(StudentDTO);
    }

    @PutMapping("/{id}")
    public StudentDTO updateStudent(@PathVariable int id, @RequestBody StudentDTO StudentDTO) {
        return studentService.updateStudent(id, StudentDTO);
    }

    @DeleteMapping("/{id}")
    public boolean deleteStudent(@PathVariable int id) {
        return studentService.deleteStudent(id);
    }

}
