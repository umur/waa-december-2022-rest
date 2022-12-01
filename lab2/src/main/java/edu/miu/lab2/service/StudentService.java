package edu.miu.lab2.service;

import edu.miu.lab2.entity.Course;
import edu.miu.lab2.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    void addStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(int id);

    void deleteStudent(int id);

    void updateStudent(int id, Student student);

    List<Student> getStudentByMajor(String major);

    List<Course> getStudentCourses(int id);

}
