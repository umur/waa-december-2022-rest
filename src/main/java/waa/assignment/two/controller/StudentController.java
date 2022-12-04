package waa.assignment.two.controller;

import org.springframework.web.bind.annotation.*;
import waa.assignment.two.dto.StudentDto;
import waa.assignment.two.model.Course;
import waa.assignment.two.sevices.StudentService;

import java.util.List;

@RequestMapping("/students")
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDto> getAllStudents() {
        return studentService.getAll();
    }

    @GetMapping("/major/{major}")
    public List<StudentDto> getStudentsByMajor(@PathVariable String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("{id}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable int id) {
        return studentService.getCoursesByStudentId(id);
    }

    @GetMapping("{id}")
    public StudentDto getStudentById(@PathVariable int id) {
        return studentService.getById(id);
    }

    @PostMapping
    public void saveStudent(@RequestBody StudentDto studentDto) {
        studentService.save(studentDto);
    }

    @PutMapping("{id}")
    public void updateStudent(@PathVariable int id, @RequestBody StudentDto studentDto) {
        studentService.update(id, studentDto);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.delete(id);
    }

}
