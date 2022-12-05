package edu.miu.w1d2.service.impl;

import edu.miu.w1d2.dto.CourseDto;
import edu.miu.w1d2.dto.StudentDto;
import edu.miu.w1d2.entity.Course;
import edu.miu.w1d2.entity.Student;
import edu.miu.w1d2.repository.StudentRepository;
import edu.miu.w1d2.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class  StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAll() {
        return studentRepository.getAllStudent()
                .stream().map(x->modelMapper.map(x,StudentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto getById(int id) {
        System.out.println("being get student by id");
        Student studentById = studentRepository.getStudentById(id);
        return modelMapper.map(studentById,StudentDto.class);
    }

    @Override
    public void create(StudentDto s) {
        studentRepository.save(modelMapper.map(s,Student.class));
    }

    @Override
    public void delete(int id) {
            studentRepository.delete(id);
    }

    @Override
    public void update(StudentDto s ,int id) {
            studentRepository.updateStudent(modelMapper.map(s,Student.class),id);
    }

    @Override
    public List<StudentDto> getByMajor(String major) {
        return  studentRepository.getStudentByMajor(major).stream()
                .map(x -> modelMapper.map(x, StudentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseDto> getCourseByStudentId(int studentId) {
       return  studentRepository.getCourseByStudentId(studentId).stream().map(x->{
            return modelMapper.map(x,CourseDto.class);
       }).collect(Collectors.toList());
    }

}
