package waa.lab2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import waa.lab2.entity.Course;
import waa.lab2.entity.Student;
import waa.lab2.services.StudentService;

import java.util.List;

/**
 * @author Ankhbayar Azzaya
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/getCoursesByStudentId/{id}")
    public List<Course> getCoursesByStudentId(@PathVariable int id) {
        return studentService.getCoursesByStudentId(id);
    }

    @GetMapping("/getStudentsByMajor/{major}")
    public List<Student> getStudentsByMajor(@PathVariable String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable int id) {
        return studentService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody Student student) {
        studentService.save(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        studentService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Student student) {
        studentService.update(id, student);
    }
}
