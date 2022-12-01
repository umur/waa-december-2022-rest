package Waa.Lab2.Controller;

import Waa.Lab2.Entity.Student;
import Waa.Lab2.Services.Serviceimpl.StudentImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentsController {


    StudentImpl studentService;

    @Autowired
    StudentsController(StudentImpl studentServiceImpl)
    {
        this.studentService = studentServiceImpl;
    }


    @GetMapping("/getStudentsByMajor")
    public Student getStudentsByMajor(@RequestParam String major) {
        return  studentService.getStudentsByMajor("Wap");
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