package edu.miu.lab2.service.impl;

import edu.miu.lab2.entity.Student;
import edu.miu.lab2.repository.StudentRepo;
import edu.miu.lab2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student findById(int id) {
        return studentRepo.findById(id);
    }

    @Override
    public List<Student> getAll() {
        return studentRepo.getAll();
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getAll().stream()
                .filter(e -> e.getMajor().contains(major))
                .collect(Collectors.toList());
    }

    @Override
    public boolean add(Student s) {
        s.setId(studentRepo.getMaxId() + 1);
        return studentRepo.add(s);
    }

    @Override
    public boolean update(int id, Student s) {
        return studentRepo.update(id, s);
    }

    @Override
    public boolean delete(int id) {
        return studentRepo.delete(id);
    }
}
