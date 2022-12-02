package waa.lab2.services.impl;

import org.springframework.stereotype.Service;
import waa.lab2.entity.Course;
import waa.lab2.entity.Student;
import waa.lab2.repository.StudentRepo;
import waa.lab2.services.StudentService;

import java.util.List;

/**
 * @author Ankhbayar Azzaya
 */
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getAll() {
        return studentRepo.getAll();
    }

    @Override
    public void save(Student student) {
        studentRepo.save(student);
    }

    @Override
    public Student getById(int id) {
        return studentRepo.getById(id);
    }

    @Override
    public void update(int id, Student student) {
        studentRepo.update(id, student);
    }

    @Override
    public void delete(int id) {
        studentRepo.delete(id);
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        return studentRepo.getCoursesByStudentId(studentId);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }
}
