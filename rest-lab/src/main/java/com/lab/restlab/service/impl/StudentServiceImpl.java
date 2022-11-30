package com.lab.restlab.service.impl;

import com.lab.restlab.dto.CourseDto;
import com.lab.restlab.dto.StudentDto;
import com.lab.restlab.entity.Student;
import com.lab.restlab.repository.StudentRepository;
import com.lab.restlab.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAll() {
        return studentRepository.getAll().stream().map(s -> modelMapper.map(s, StudentDto.class)).toList();
    }

    @Override
    public StudentDto getById(int id) {
        Student result = studentRepository.getById(id);
        return modelMapper.map(result, StudentDto.class);
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        return studentRepository.getStudentsByMajor(major).stream().map(s -> modelMapper.map(s, StudentDto.class)).toList();
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int studentId) {
        return studentRepository.getCoursesByStudentId(studentId).stream().map(c -> modelMapper.map(c, CourseDto.class)).toList();
    }

    @Override
    public void save(StudentDto studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);
        studentRepository.save(student);
    }

    @Override
    public StudentDto update(int id, StudentDto studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);
        Student result = studentRepository.update(id, student);
        return modelMapper.map(result, StudentDto.class);
    }

    @Override
    public void delete(int id) {
        studentRepository.delete(id);
    }
}
