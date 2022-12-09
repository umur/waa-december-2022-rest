package Waa.Lab2.Controller;

import Waa.Lab2.Entity.Course;
import Waa.Lab2.Entity.Student;
import Waa.Lab2.Services.Serviceimpl.StudentImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    StudentImpl studentService;

    @GetMapping("/getStudentsByMajor")
    public List<Student> getStudentsByMajor(@RequestParam String major) {
        return  studentService.getStudentsByMajor("Wap");
    }
    @GetMapping("/{id}/courses")
    public List<Course> getCourseById(@RequestParam int identity) {
        return  studentService.getCoursesByStudentId(identity);
    }

    @PostMapping
    public void add(@RequestBody Student student)
    {
        studentService.add(student);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Student student, @PathVariable int id)
    {
        studentService.update(student,id);
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable int id)
    {
        studentService.Delete(id);
    }

}