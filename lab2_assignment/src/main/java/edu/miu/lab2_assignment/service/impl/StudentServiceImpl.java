package edu.miu.lab2_assignment.service.impl;

import edu.miu.lab2_assignment.entity.Student;
import edu.miu.lab2_assignment.repository.StudentRepo;
import edu.miu.lab2_assignment.service.StudentService;

import java.util.List;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getStudentList() {
        return null;
    }

    @Override
    public Student getById(int id) {
        return null;
    }

    @Override
    public void save(Student student) {

    }
    @Override
    public void update(int id, Student student) {

    }
    @Override
    public void deleteById(int id) {

    }
}
