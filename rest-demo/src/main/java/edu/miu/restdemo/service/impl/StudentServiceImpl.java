package edu.miu.restdemo.service.impl;

import edu.miu.restdemo.dto.CourseDto;
import edu.miu.restdemo.dto.StudentDto;
import edu.miu.restdemo.entity.Course;
import edu.miu.restdemo.entity.Student;
import edu.miu.restdemo.repository.StudentRepo;
import edu.miu.restdemo.service.CourseService;
import edu.miu.restdemo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    @Override
    public StudentDto getById(int id) {
        // validation
        // authorization
        // logging
        StudentDto dto = new StudentDto();
        return dto.toDto(studentRepo.getById(id));
    }

    @Override
    public void save(StudentDto s) {
        // validate
        StudentDto dto = new StudentDto();
        studentRepo.save(dto.toEntity(s));
    }

    @Override
    public List<StudentDto> getAllStudents() {
        StudentDto dto = new StudentDto();
        List<Student> tempList = studentRepo.getAllStudents();
        List<StudentDto> result = tempList.stream()
                .map(s -> dto.toDto(s))
                .collect(Collectors.toList());
        return result;

    }

    @Override
   public List<StudentDto> getStudentsByMajor(String major){
        System.out.printf("get StudentByMajor in service %s%n", major);

        StudentDto dto = new StudentDto();
        List<Student> tempList = studentRepo.getStudentsByMajor(major);
        List<StudentDto> result = tempList.stream()
                .map(s -> dto.toDto(s))
                .collect(Collectors.toList());
        return result;
    };

    @Override
    public List<CourseDto> getCoursesByStudentId(int studentId){
        System.out.printf("get getCoursesByStudentId in service %s%n", studentId);

        CourseDto dto = new CourseDto();
        List<Course> tempList = studentRepo.getCoursesByStudentId(studentId);
        List<CourseDto> result = tempList.stream().map(c -> dto.toDto(c)).collect(Collectors.toList());

        return  result;
    };

    @Override
    public boolean delete (int id){
        return studentRepo.delete(id);
    }
}
