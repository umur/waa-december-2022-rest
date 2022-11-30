package lab.waa.rest.service.impl;

import lab.waa.rest.entity.Course;
import lab.waa.rest.entity.Student;
import lab.waa.rest.repository.StudentRepo;
import lab.waa.rest.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    @Override
    public List<Student> getStudents(int offset, int count) {
        return studentRepo.getStudents(offset, count);
    }

    @Override
    public Student getById(int id) {
        return studentRepo.getById(id);
    }

    @Override
    public void deleteById(int id) {
        studentRepo.deleteById(id);
    }

    @Override
    public void updateById(int id, Student student) {
        studentRepo.updateById(id, student);
    }

    @Override
    public void save(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void addCourseTaken(int studentId, Course course) {
        studentRepo.addCourseTaken(studentId, course);
    }
}
