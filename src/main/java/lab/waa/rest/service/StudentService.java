package lab.waa.rest.service;

import lab.waa.rest.entity.Course;
import lab.waa.rest.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudents(int offset, int count);
    Student getById(int id);
    void deleteById(int id);
    void updateById(int id, Student student);
    void save (Student student);
    void addCourseTaken(int studentId, Course course);
    List<Student> getStudentsByMajor(String major);
}
