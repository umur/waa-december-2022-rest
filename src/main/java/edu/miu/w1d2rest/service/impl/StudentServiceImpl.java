package edu.miu.w1d2rest.service.impl;

import edu.miu.w1d2rest.dto.CourseDto;
import edu.miu.w1d2rest.dto.StudentDto;
import edu.miu.w1d2rest.entity.Course;
import edu.miu.w1d2rest.entity.Student;
import edu.miu.w1d2rest.repository.CourseRepo;
import edu.miu.w1d2rest.repository.StudentRepo;
import edu.miu.w1d2rest.service.CourseService;
import edu.miu.w1d2rest.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAll() {
        List<Student> students = studentRepo.getAll();
        List<StudentDto> list = students.stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .collect(Collectors.toList());

        return list;
    }

    @Override
    public List<StudentDto> getAllByMajor(String major) {
        List<Student> students = studentRepo.getAllByMajor(major);
        List<StudentDto> list = students.stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .collect(Collectors.toList());

        return list;
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int id) {
        var courses = studentRepo.getCoursesByStudentId(id);
        List<CourseDto> list = courses.stream()
                .map(course -> modelMapper.map(course, CourseDto.class))
                .collect(Collectors.toList());

        return list;
    }

    @Override
    public void save(StudentDto student) {
        var entity = modelMapper.map(student, Student.class);
        studentRepo.save(entity);
    }

    @Override
    public void update(int id, StudentDto student) {
        var entity = modelMapper.map(student, Student.class);
        studentRepo.update(id, entity);
    }

    @Override
    public void delete(int id) {
        studentRepo.deleteById(id);
    }

    @Override
    public StudentDto getById(int id) {
        Student entity = studentRepo.getById(id);
        return modelMapper.map(entity, StudentDto.class);
    }
}
