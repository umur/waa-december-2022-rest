package edu.miu.lab2.controller;

import edu.miu.lab2.entity.Student;
import edu.miu.lab2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@CrossOrigin
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.findById(id);
    }

    @GetMapping("/filter")
    public List<Student> getStudentsByMajor(@RequestParam String major) {
        return studentService.getStudentsByMajor(major);
    }

    @PostMapping
    public String add(@RequestBody Student student) {
        var result = studentService.add(student);

        if(result)
            return "Saved successfully.";
        else
            return "Error during create operation.";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Student student) {
        var result = studentService.update(id, student);

        if(result)
            return "Updated successfully.";
        else
            return "Error during update operation.";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        var result = studentService.delete(id);

        if(result)
            return "Deleted successfully.";
        else
            return "Error during delete operation.";
    }
}
