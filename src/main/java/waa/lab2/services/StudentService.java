package waa.lab2.services;


import waa.lab2.entity.Course;
import waa.lab2.entity.Student;

import java.util.List;

/**
 * @author Ankhbayar Azzaya
 */
public interface StudentService {
    List<Student> getAll();
    void save(Student student);
    Student getById(int id);

    void update(int id, Student student);

    void delete(int id);

    List<Course> getCoursesByStudentId(int studentId);

    List<Student> getStudentsByMajor(String Major);
}
