package edu.miu.lab2.restdemo.service.impl;

import edu.miu.lab2.restdemo.dto.StudentDto;
import edu.miu.lab2.restdemo.entity.Student;
import edu.miu.lab2.restdemo.repository.StudentRespo;
import edu.miu.lab2.restdemo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRespo studentRespo;
    @Override
    public List<Student> getStudents() {
        return studentRespo.findAll();
    }

    @Override
    public Student getId(int id) {

        return studentRespo.getId(id);
    }

    @Override
    public void update(Student c, int id) {
        studentRespo.update(c, id);
    }

    @Override
    public void delete(int id) {
        studentRespo.delete(id);
    }

    @Override
    public void save(Student student) {
        studentRespo.save(student);
    }
}
