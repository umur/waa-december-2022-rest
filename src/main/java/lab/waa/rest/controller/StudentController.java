package lab.waa.rest.controller;

import lab.waa.rest.entity.Course;
import lab.waa.rest.entity.Student;
import lab.waa.rest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/students")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents(0, 100);
    }
    @GetMapping("/paging")
    public List<Student> getStudents(int offset, int count) {
        return studentService.getStudents(offset, count);
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable int id) {
        return studentService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody Student student) {
        studentService.save(student);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Student student) {
        studentService.updateById(id, student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        studentService.deleteById(id);
    }

    @PutMapping("addCourseTaken/{id}")
    public void addCourseTaken(@PathVariable int id, @RequestBody Course course) {
        studentService.addCourseTaken(id, course);
    }

    @GetMapping("/bymajor/{major}")
    public List<Student> getStudentsByMajor(@PathVariable String major){
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/coursebystudent/{studentId}")
    public List<Course> getCou(@PathVariable int studentId){
        return studentService.getCoursesByStudentId(studentId);
    }
}
