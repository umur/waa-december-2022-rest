package com.miu.edu.rest.service.impl;

import com.miu.edu.rest.entity.Course;
import com.miu.edu.rest.entity.Student;

import com.miu.edu.rest.repository.StudentRepository;
import com.miu.edu.rest.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<Student> getAll() {
        return studentRepository.getAll();
    }

//    @Override
//    public List<Student2> getAll2() {
//        return studentRepository.getAll2();
//    }

    @Override
    public List<Course> getCoursesByStudentId(int id) {
        return studentRepository.getCoursesByStudentId(id);
    }

    @Override
    public List<Student> getStudentByMajor(String major) {
        return studentRepository.getStudentByMajor(major);
    }


    @Override
    public void save(Student s) {
        studentRepository.save(s);
    }

//    @Override
//    public void save2(Student2 s) {
//        studentRepository.save2(s);
//    }

    @Override
    public void update(Student s, int id) {
        studentRepository.update(s, id);
    }

    @Override
    public void delete(int id) {
        studentRepository.delete(id);
    }

    @Override
    public Student getById(int id) {
        return null;
    }
}
