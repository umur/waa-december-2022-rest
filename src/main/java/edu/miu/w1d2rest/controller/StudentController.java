package edu.miu.w1d2rest.controller;

import edu.miu.w1d2rest.dto.CourseDto;
import edu.miu.w1d2rest.dto.StudentDto;
import edu.miu.w1d2rest.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/students")
@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    @PreAuthorize("hasAnyRole('admin','user')")
    public List<StudentDto> getAll(){
        System.out.println("Get all request received.");
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('admin','user')")
    public StudentDto getById(@PathVariable int id){
        System.out.println("Get request received for id: " + String.valueOf(id));
        return studentService.getById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('user')")
    public void create(@RequestBody StudentDto student){
        System.out.println("Post request received: " + student.toString());
        studentService.save(student);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('user')")
    public void update(@PathVariable int id, @RequestBody StudentDto student){
        System.out.println("Update request received for id: " + String.valueOf(id) + " with request body: " + student.toString());
        studentService.update(id, student);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('user')")
    public void delete(@PathVariable int id){
        System.out.println("Delete request received for id: " + String.valueOf(id));
        studentService.delete(id);
    }

    @GetMapping("/filterByMajor")
    @PreAuthorize("hasAnyRole('admin','user')")
    public List<StudentDto> getStudentsByMajor(@RequestParam String major){
        System.out.println("Get Students by major request received.");
        return studentService.getAllByMajor(major);
    }

    @GetMapping("/{id}/courses")
    @PreAuthorize("hasAnyRole('admin','user')")
    public List<CourseDto> getCoursesByStudentId(@PathVariable int id){
        System.out.println("Get courses by student id request received.");
        return studentService.getCoursesByStudentId(id);
    }
}
