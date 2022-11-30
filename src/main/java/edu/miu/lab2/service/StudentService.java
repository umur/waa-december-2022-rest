package edu.miu.lab2.service;

import edu.miu.lab2.model.Course;
import edu.miu.lab2.model.Student;
import edu.miu.lab2.model.dto.StudentDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface StudentService {
    public List<StudentDTO> findAllStudents();
    public void addStudent(StudentDTO studentDTO);
    public void deleteStudent(int id);
    public void updateStudent(int id, StudentDTO studentDTO);

    public List<Student> getStudentsByMajor(String major);
    public List<Course> getCoursesByStudentId(int studentId);
}
