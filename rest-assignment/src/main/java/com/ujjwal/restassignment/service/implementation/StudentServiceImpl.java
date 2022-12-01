package com.ujjwal.restassignment.service.implementation;

import com.ujjwal.restassignment.dto.CourseDto;
import com.ujjwal.restassignment.dto.StudentDto;
import com.ujjwal.restassignment.entity.Student;
import com.ujjwal.restassignment.repository.StudentRepository;
import com.ujjwal.restassignment.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    public final StudentRepository studentRepository;
    public final ModelMapper modelMapper;
    @Override
    public void save(StudentDto studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);
        studentRepository.save(student);
    }

    @Override
    public StudentDto update(int id, StudentDto studentDto) {
        Student student = modelMapper.map(studentDto,Student.class);
        Student result = studentRepository.update(id,student);
        return modelMapper.map(result,StudentDto.class);
    }

    @Override
    public void delete(int id) {
        studentRepository.delete(id);
    }

    @Override
    public StudentDto getById(int id) {
        Student result = studentRepository.getById(id);
        return modelMapper.map(result,StudentDto.class);
    }

    @Override
    public List<StudentDto> getAll() {
        return studentRepository.getAll().stream().map(student -> modelMapper.map(student, StudentDto.class)).toList();
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        return studentRepository.getStudentsByMajor(major).stream().map(student -> modelMapper.map(student,StudentDto.class)).toList();
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int studentId) {
        return studentRepository.getCoursesByStudentId(studentId).stream().map(course -> modelMapper.map(course,CourseDto.class)).toList();
    }
}