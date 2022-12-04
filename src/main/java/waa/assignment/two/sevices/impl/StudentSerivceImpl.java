package waa.assignment.two.sevices.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import waa.assignment.two.dto.StudentDto;
import waa.assignment.two.model.Course;
import waa.assignment.two.model.Student;
import waa.assignment.two.repository.StudentRepo;
import waa.assignment.two.sevices.StudentService;

@Service
public class StudentSerivceImpl implements StudentService {

    private final StudentRepo studentRepo;
    private final ModelMapper modelMapper;

    public StudentSerivceImpl(StudentRepo studentRepo, ModelMapper modelMapper) {
        this.studentRepo = studentRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public StudentDto getById(int id) {
        return modelMapper.map(studentRepo.getById(id), StudentDto.class);

    }

    @Override
    public void save(StudentDto studentDto) {
        studentRepo.save(modelMapper.map(studentDto, Student.class));

    }



    @Override
    public void delete(int id) {
        studentRepo.delete(id);


    }

    @Override
    public List<StudentDto> getAll() {
        return studentRepo.getStudents().stream().map(student -> modelMapper.map(student, StudentDto.class)).toList();
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major).stream().map(student -> modelMapper.map(student, StudentDto.class)).toList();
    }

    @Override
    public List<Course> getCoursesByStudentId(int id) {
        return studentRepo.getCoursesByStudentId(id);
    }

    @Override
    public void update(int id,StudentDto studentDto) {
        studentRepo.update(id, modelMapper.map(studentDto, Student.class));
    }

}
