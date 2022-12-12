package com.example.demo.service;


import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Override
    public List<Student> getAllStudentByMajor(String major) {
        return studentRepo.getAllStudentByMajor(major);
    }

    @Override
    public List<Course> getCourseByStudentId(int studentId) {
        return studentRepo.getAllStudentByMajor(studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.getAllStudents();
    }
}
