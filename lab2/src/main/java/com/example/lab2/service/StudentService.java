package com.example.lab2.service;

import com.example.lab2.dto.StudentBasicDto;
import com.example.lab2.entity.Course;
import com.example.lab2.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    StudentBasicDto getStudentById(int id);
    void save(Student s);
    List<StudentBasicDto> getAllStudent();
    String deleteStudentById(int id);
    void updateStudent(int id, StudentBasicDto student);
    List<Course> getCourseByStudentId(int id);
    public List<Student> getStudentsByMajor(String major);

}
