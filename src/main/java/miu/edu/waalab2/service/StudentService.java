package miu.edu.waalab2.service;

import miu.edu.waalab2.entity.Course;
import miu.edu.waalab2.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudentByMajor(String major);
    public List<Course> getCourseByStudentId(int studentId);
    public List<Student> getAllStudents();
}
