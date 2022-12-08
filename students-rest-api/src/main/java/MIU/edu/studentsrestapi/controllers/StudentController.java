package MIU.edu.studentsrestapi.controllers;

import MIU.edu.studentsrestapi.dtos.CourseDto;
import MIU.edu.studentsrestapi.dtos.StudentDto;
import MIU.edu.studentsrestapi.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;


    @GetMapping
    public List<StudentDto> getStudentsByMajor() {
        return studentService.getStudents();
    }

//
//    @GetMapping("/students/{major}")
//    public List<StudentDto> getStudentsByMajor(@PathVariable String major) {
//        return studentService.getStudentsByMajor(major);
//    }


    @GetMapping("/{studentId}")
    public StudentDto getStudent(@PathVariable int studentId) {
        return studentService.getStudent(studentId);
    }


    @GetMapping("/student-courses/{studentId}")
    public List<CourseDto> getStudentByStudentId(@PathVariable int studentId) {
        return studentService.getCoursesByStudentId(studentId);
    }


    @DeleteMapping("/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {
        return studentService.deleteStudent(studentId);
    }


    @PutMapping("/{studentId}")
    public String updateStudent(@PathVariable int studentId, @RequestBody StudentDto studentDto) {
        return studentService.updateStudent(studentId, studentDto);
    }


    @PostMapping
    public String addStudent(@RequestBody StudentDto studentDto) {
        return studentService.addStudent(studentDto);
    }
}
