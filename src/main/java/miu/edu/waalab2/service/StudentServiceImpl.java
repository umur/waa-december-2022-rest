package miu.edu.waalab2.service;

import miu.edu.waalab2.entity.Course;
import miu.edu.waalab2.entity.Student;
import miu.edu.waalab2.repository.StudentRepo;
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
