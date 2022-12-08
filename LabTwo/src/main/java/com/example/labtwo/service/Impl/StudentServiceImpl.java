package com.example.labtwo.service.Impl;

import com.example.labtwo.entity.Student;
import com.example.labtwo.repository.CourseRepo;
import com.example.labtwo.repository.StudentRepo;
import com.example.labtwo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {


    private final StudentRepo sRepo;


    @Override
    public void add(Student student) {
        sRepo.add(student);

    }

    @Override
    public Student getById(int id) {
        return (Student) sRepo.getCoursesByStudentId(id);
    }

    @Override
    public void update(int id, Student student) {
        sRepo.update(id, student);

    }

    @Override
    public void delete(int id) {
        sRepo.delete(id);

    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return sRepo.getAll().stream()
                .filter(x -> x.getCoursesTaken().stream().filter(y -> y.getName().equals(major)).count() > 0)
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> getCoursesByStudentId(int id) {
        return null;
    }
}
